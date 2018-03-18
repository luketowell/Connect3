package com.luketowell.connect3;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.Toast;


public class WinnerDialog {

    public void open(final Activity MainActivity, String winner){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity);
        alertDialogBuilder.setMessage("The winner is: "+ winner +"\n Would you like to play again?")
                .setTitle("Winner!");
        alertDialogBuilder.setPositiveButton("yes",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        Toast.makeText(MainActivity,"You clicked yes button",Toast.LENGTH_LONG).show();
                        MainActivity.recreate();
                    }
                });

        alertDialogBuilder.setNegativeButton("No",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                MainActivity.finish();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
