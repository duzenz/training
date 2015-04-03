package com.duzenz;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AlertDialogActivity extends Activity {

    private static final int DIALOG_SAVE_CONFIRM = 0;
    private static final int DIALOG_CHOOSE_ITEM = 1;
    private static final int DIALOG_CHOOSE_ITEM_CHECKED = 2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Button saveButton = (Button) findViewById(R.id.saveButton);
        Button chooseProductButton = (Button) findViewById(R.id.chooseProductButton);
        Button chooseProductWithCheck = (Button) findViewById(R.id.chooseProductWithCheck);
        Button progressDialogButton = (Button) findViewById(R.id.progressDialogButton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showDialog(DIALOG_SAVE_CONFIRM);
            }
        });

        chooseProductButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showDialog(DIALOG_CHOOSE_ITEM);
            }
        });

        chooseProductWithCheck.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showDialog(DIALOG_CHOOSE_ITEM_CHECKED);
            }
        });

        progressDialogButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ProgressDialog.show(AlertDialogActivity.this, "",
                        "Please wait...", true, true);
            }
        });
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        Dialog dialog;
        switch (id) {
            case DIALOG_SAVE_CONFIRM:
                dialog = getSaveConfirmDialog();
                break;
            case DIALOG_CHOOSE_ITEM:
                dialog = getChooseItemDialog();
                break;
            case DIALOG_CHOOSE_ITEM_CHECKED:
                dialog = getChooseItemCheckedDialog();
                break;
            default:
                dialog = null;
        }
        return dialog;
    }

    private Dialog getSaveConfirmDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage("Are you sure to save?");

        builder.setPositiveButton("Yes",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    }
                });

        builder.setNegativeButton("No",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        builder.setCancelable(false);

        return builder.create();

    }

    private Dialog getChooseItemDialog() {

        final CharSequence[] items = {"Shoes", "Hats"};

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Choose Product");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                dialog.dismiss();
            }
        });
        return builder.create();
    }

    private Dialog getChooseItemCheckedDialog() {

        final CharSequence[] items = {"Shoes", "Hats"};

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Choose Product");
        builder.setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                dialog.dismiss();
            }
        });

        return builder.create();
    }
}