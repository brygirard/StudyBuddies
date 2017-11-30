package com.example.bryan.studybuddies;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;


import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.ui.IconGenerator;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                Intent myIntent = new Intent(MapsActivity.this, place.class);
                startActivity(myIntent);
                return false;
            }
        });

        // Add a marker in Sydney and move the camera
        LatLng grainger = new LatLng(40.112500, -88.226917);
        LatLng siebel = new LatLng(40.113803, -88.224905);
        LatLng def = new LatLng(40.113787, -88.228111);

        IconGenerator icnGenerator = new IconGenerator(this);
        Bitmap custIcon = icnGenerator.makeIcon("Siebel Center \n 3 People Checked In");

        mMap.addMarker(new MarkerOptions().position(siebel).icon(BitmapDescriptorFactory.fromBitmap(custIcon)));

        custIcon = icnGenerator.makeIcon("Grainger Library \n 4 People Checked In ");

        mMap.addMarker(new MarkerOptions().position(grainger).icon(BitmapDescriptorFactory.fromBitmap(custIcon)));
        float zoomLevel = 16.0f;
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(def, zoomLevel));

    }

    public boolean onMarkerClick(final Marker marker) {



        return true;
    }
}
