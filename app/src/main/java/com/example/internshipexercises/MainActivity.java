package com.example.internshipexercises;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MapView mapView = findViewById(R.id.map);
        mapView.onCreate(savedInstanceState);
        mapView.onResume();

        mapView.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng coord = new LatLng(46.7676919, 23.5709693);
        googleMap.addMarker(new MarkerOptions().position(coord));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(coord,16));

        googleMap.addMarker(new MarkerOptions().position(coord).title("Porto").snippet("Welcome to Porto, Portugal!"));

    }
}
