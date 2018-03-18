package com.luketowell.connect3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setPlayer();

    }

    int activePlayer = 0;

    int count = 0;

    int[] activeState = {2,2,2,2,2,2,2,2,2};

    int [][] winningPositions = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    WinnerDialog winnerDialog = new WinnerDialog();

    String player = "";

    public void setPlayer(){
        TextView currentGo = findViewById(R.id.playerName);
        switch (activePlayer){
            case 0 :
                player = "Yellow";
                currentGo.setText(player);
                break;
            case 1 :
                player = "Red";
                currentGo.setText(player);
                break;
        }
    }

    public void restart(View view){
        recreate();
    }

    public void position (View view){
        count ++;

        ImageView clicked = findViewById(view.getId());

        int clickedPosition = Integer.parseInt(view.getTag().toString());

        if (activeState[clickedPosition] == 2) {

            if (activePlayer == 1) {
                clicked.setImageResource(R.drawable.red);
                activeState[clickedPosition] = activePlayer;
                activePlayer = 0;
                setPlayer();

            } else {
                clicked.setImageResource(R.drawable.yellow);
                activeState[clickedPosition] = activePlayer;
                activePlayer = 1;
                setPlayer();

            }

            for(int[] combination:winningPositions){

                if (activeState[combination[0]] == activeState[combination[1]]
                        && activeState[combination[1]] == activeState[combination[2]]
                        && activeState[combination[0]] != 2) {
                    if (player.equals("Red")){
                        winnerDialog.open(this,"yellow");
                    }
                    else{
                        winnerDialog.open(this,"Red");
                    }

                }
            }
            System.out.println(activeState[Integer.parseInt(view.getTag().toString())]);

        }
        else {
            System.out.println("Someone has already taken this position");
        }
    }

}
