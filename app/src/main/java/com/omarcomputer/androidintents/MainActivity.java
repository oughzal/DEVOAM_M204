package com.omarcomputer.androidintents;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btnOpenActivity,btnSend,btnSendData;
    EditText editMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnOpenActivity = findViewById(R.id.btnOpenActivity);
        btnSend = findViewById(R.id.btnSend);
        btnSendData = findViewById(R.id.btnSendData);
        editMessage = findViewById(R.id.editMessage);

        btnOpenActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO : créer une Intent pour ouvrir l'activity MainActivity2
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO : Créer une Intent pour envoyer un
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT,editMessage.getText().toString());
                //TODO : créer une Intent pour choisir une application
                Intent chooser = Intent.createChooser(intent,"Choisir une application");

                startActivity(chooser);
            }
        });

        btnSendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: envoyer le texte à afficher dans MainActivity2
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("title",editMessage.getText().toString());
                startActivity(intent);

            }
        });
    }



}