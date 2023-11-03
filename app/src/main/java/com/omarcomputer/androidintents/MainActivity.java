package com.omarcomputer.androidintents;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btnOpenActivity, btnSend, btnSendData, btnSetAlarm, btnShowMap,btnShowCamera;
    EditText editMessage;
    Spinner selectHoures, selectMinutes;
    List<String> houresList = new ArrayList<String>();
    List<String> minutesList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnOpenActivity = findViewById(R.id.btnOpenActivity);
        btnSend = findViewById(R.id.btnSend);
        btnSendData = findViewById(R.id.btnSendData);
        editMessage = findViewById(R.id.editMessage);
        selectHoures = findViewById(R.id.selectHour);
        selectMinutes = findViewById(R.id.selectMinute);
        btnSetAlarm = findViewById(R.id.btnSetAlarm);
        btnShowMap = findViewById(R.id.btnShowMap);
        btnShowCamera = findViewById(R.id.btnShowCamera);

        for (int i = 0; i < 24; i++) {
            houresList.add("" + i);
        }
        for (int i = 0; i < 60; i++) {
            minutesList.add("" + i);
        }

        ArrayAdapter<String> houtesAdaper = new ArrayAdapter(this, android.R.layout.simple_spinner_item, houresList);
        selectHoures.setAdapter(houtesAdaper);

        ArrayAdapter<String> minutesAdaper = new ArrayAdapter(this, android.R.layout.simple_spinner_item, minutesList);
        selectMinutes.setAdapter(minutesAdaper);


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
                intent.putExtra(Intent.EXTRA_TEXT, editMessage.getText().toString());
                //TODO : créer une Intent pour choisir une application
                Intent chooser = Intent.createChooser(intent, "Choisir une application");

                startActivity(chooser);
            }
        });

        btnSendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: envoyer le texte à afficher dans MainActivity2
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("title", editMessage.getText().toString());
                startActivity(intent);

            }
        });

        btnSetAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO : créer une alarme avec le données heures, minutes et un message (nécessite la permission :com.android.alarm.permission.SET_ALARM)
                int h = selectHoures.getSelectedItemPosition() + 1;
                int m = selectMinutes.getSelectedItemPosition() + 1;
                String msg = editMessage.getText().toString();
                Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM);
                intent.putExtra(AlarmClock.EXTRA_HOUR, h);
                intent.putExtra(AlarmClock.EXTRA_MINUTES, m);
                intent.putExtra(AlarmClock.EXTRA_MESSAGE, msg);
                intent.putExtra(AlarmClock.EXTRA_VIBRATE, true);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

        btnShowMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO : Afficher une position sur la carte
                String location = "geo:37.4220,-122.0841";
                //String location = "geo:0,0?q=37.4220,-122.0841(GooglePlex)";
                //String location = "geo:0,0?q=20+W+34th+St+10001";
                //String location = "geo:47.6205,-122.3493?q=restaurants";

                // Parse the location using the Uri class
                Uri geoLocUri = Uri.parse(location);

                // Pass the Uri directly to the Intent constructor
                Intent intent = new Intent(Intent.ACTION_VIEW, geoLocUri);
                Intent chooser = Intent.createChooser(intent,"");
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(chooser);
                }
            }
        });

        btnShowCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Take a picture and consume the returned result bitmap
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });
    }


}