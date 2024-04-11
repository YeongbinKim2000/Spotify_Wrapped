package com.example.spotifywrappedproject2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Settings extends AppCompatActivity {

    Class<?> className;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Button updateAcc = findViewById(R.id.updateacc);
        ImageButton back = findViewById(R.id.backArrow);
        ImageButton delAcc = findViewById(R.id.delButton);

        Intent intent = getIntent();
        if (intent != null) {
            try {
                className = Class.forName(intent.getStringExtra("sourceClass"));
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        updateAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Settings.this, UpdateAcc.class);
                if (myIntent != null) {
                    startActivity(myIntent);
                }
            }

        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Settings.this, className);
                startActivity(intent);
            }
        });

        delAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new  AlertDialog.Builder(Settings.this)
                        .setMessage("Are you sure you want to delete your account?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        })
                        .setNegativeButton("No", null)
                        .show();
            }
        });
    }


}