package com.omarcomputer.androidintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView targetText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        targetText = findViewById(R.id.targetText);
        Intent intent = getIntent();
        if(intent !=null){
            targetText.setText(intent.getStringExtra("title"));
        }

    }
}