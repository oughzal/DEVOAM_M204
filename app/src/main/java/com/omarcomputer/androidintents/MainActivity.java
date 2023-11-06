package com.omarcomputer.androidintents;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;


import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private final static int GET_IMAGE_CAPTURE = 1000;
    ActivityResultLauncher<Void> photoLauncher = registerForActivityResult(new ActivityResultContracts.TakePicturePreview(), new ActivityResultCallback<Bitmap>() {
        @Override
        public void onActivityResult(Bitmap result) {
            targetImage.setImageBitmap(result);
        }
    });


    Button btnOpenActivity, btnSend, btnSendData, btnShowMap, btnShowCamera, btnDialPhone, btnOpenUrl, btnShowGallery;
    EditText editMessage;

    ImageView targetImage;

    ActivityResultLauncher<Intent> chooseImage = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
        if (result.getResultCode() == RESULT_OK && result.getData() != null) {
            Uri uri = result.getData().getData();
            targetImage.setImageURI(uri);
        }
    });


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnOpenActivity = findViewById(R.id.btnOpenActivity);
        btnSend = findViewById(R.id.btnSend);
        btnSendData = findViewById(R.id.btnSendData);
        editMessage = findViewById(R.id.editMessage);
        btnShowMap = findViewById(R.id.btnShowMap);
        btnShowCamera = findViewById(R.id.btnShowCamera);
        btnShowGallery = findViewById(R.id.btnShowGallery);
        btnDialPhone = findViewById(R.id.btnDialPhone);
        btnOpenUrl = findViewById(R.id.btnOpenUrl);
        targetImage = findViewById(R.id.targetImage);


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


        btnShowMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO : Afficher une position sur la carte
                //String location = "geo:32.94988983365049, -5.662560173657064";
                String location = "geo:0,0?q=32.94988983365049, -5.662560173657064(ISTA KHENIFRA(DEV201))";
                //String location = "geo:0,0?q=20+W+34th+St+10001";
                //String location = "geo:32.94988983365049, -5.662560173657064?q=restaurants";

                // Parse the location using the Uri class
                Uri geoLocUri = Uri.parse(location);

                // Pass the Uri directly to the Intent constructor
                Intent intent = new Intent(Intent.ACTION_VIEW, geoLocUri);
                Intent chooser = Intent.createChooser(intent, "");
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(chooser);
                }
            }
        });

        btnShowCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkPermision(Manifest.permission.CAMERA)) {
                    photoLauncher.launch(null);
                } else {
                    requestPermision(Manifest.permission.CAMERA);
                }


                 /*
                 Old method : not working
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (intent.resolveActivity(getPackageManager()) != null) {
                   // startActivityForResult(intent,GET_IMAGE_CAPTURE);
                }

                  */
            }
        });

        btnShowGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                chooseImage.launch(intent);

            }
        });
        btnDialPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkPermision(Manifest.permission.CALL_PHONE)){
                    String uri = "tel:0663560419";
                    Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse(uri));
                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent);
                    }
                }else {
                    requestPermision(Manifest.permission.CALL_PHONE);
                }

            }
        });

        btnOpenUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://www.ofppt.ma";
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }

            }
        });
    }

    private boolean checkPermision(String permission) {

        return ActivityCompat.checkSelfPermission(getApplicationContext(), permission) == PackageManager.PERMISSION_GRANTED;
    }

    private void requestPermision(String permision) {
        if (!checkPermision(permision)) {
            ActivityCompat.requestPermissions(this, new String[]{permision}, 1111);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == GET_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            targetImage.setImageBitmap(imageBitmap);

        }
    }
}