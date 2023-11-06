package com.omarcomputer.androidintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView targetText;
    ImageView targetImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        targetText = findViewById(R.id.targetText);
        targetImage = findViewById(R.id.targetImage);
        Intent intent = getIntent();
        String type = intent.getType();
        if(type ==null){
            targetText.setText(intent.getStringExtra("title"));
        }else{
            if ( Intent.ACTION_SEND.equals(intent.getAction()) && type.startsWith("image/")){
                Uri imageUri = (Uri) intent.getParcelableExtra(Intent.EXTRA_STREAM);
                if (imageUri != null) {
                    targetImage.setImageURI(imageUri);
                }
            }
        }

    }
}