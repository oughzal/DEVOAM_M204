package com.omarcomputer.adroidpermissions;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.omarcomputer.adroidpermissions.databinding.ActivityMainBinding;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    LocationManager locationManager;
    LocationListener locationListener;
    FusedLocationProviderClient fusedLocationProviderClient;
    ActivityMainBinding binding;
    double latitude;
    double longitude;



    @SuppressLint("MissingPermission")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnGetLocation.setOnClickListener(v -> {

            // TODO : vérifier si l'application à les permision de localisation
            if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                //TODO : demander la permission
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, 100);
                return;
            }
            locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

            locationListener = new LocationListener() {
                @Override
                public void onLocationChanged(Location location) {
                    double latitude = location.getLatitude();
                    double longitude = location.getLongitude();
                    binding.txtLatitude.setText("" + latitude);
                    binding.txtLongitude.setText("" + longitude);
                    Geocoder geocoder = new Geocoder(getApplicationContext());
                    try {
                        List<Address> address = geocoder.getFromLocation(latitude,longitude,1);
                        binding.txtVille.setText(""+address.get(0).getLocality());
                        binding.txtCountry.setText(""+address.get(0).getCountryName());
                        String imagePath = "" + address.get(0).getCountryCode()+".png";
                        AssetManager assetManager = getAssets();
                        InputStream is = assetManager.open(imagePath.toLowerCase());
                        Bitmap bitmap = BitmapFactory.decodeStream(is);
                        binding.flag.setImageBitmap(bitmap);
                    } catch (IOException e) {
                       // throw new RuntimeException(e);
                    }
                }
                // Implémenter les autres méthodes de LocationListener
            };

            // Vérifier et demander les permissions, puis :
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);

        });
    }


    // TODO : exécuté après le choix d'accorder ou réfuser la permission
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 100:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //TODO : utiliser la localisatoin
                }
        }

    }
}