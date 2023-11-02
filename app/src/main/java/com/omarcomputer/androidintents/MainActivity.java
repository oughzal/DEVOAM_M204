package com.omarcomputer.androidintents;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener{

    Button btnOpenActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnOpenActivity = findViewById(R.id.btnOpenActivity);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        // Cliquer sur le bouton open Activity
        if(id==R.id.btnOpenActivity){
            //TODO : créer une Intent pour ouvrire l'activity MainActivity2
        }
    }
}