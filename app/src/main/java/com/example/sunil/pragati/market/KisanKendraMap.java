package com.example.sunil.pragati.market;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sunil.pragati.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class KisanKendraMap extends AppCompatActivity implements OnMapReadyCallback{


    private Toolbar mToolbar;

    GoogleMap googleMap;
    MapView mapView;
    View mView;
    private static final LatLng Kgp = new LatLng(22.525497, 86.875132);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kisan_kendra_map);

        mapView  = (MapView) findViewById(R.id.map);
        if (mapView != null) {
            mapView.onCreate(null);
            mapView.onResume();
            mapView.getMapAsync(this);

        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        MapsInitializer.initialize(getApplicationContext());
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        googleMap.addMarker(new MarkerOptions().position(new LatLng(22.525497, 86.875132)).title("Seva Bharati Krishi Vigyan Kendra").snippet("Kapgari"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(22.676535, 88.123353)).title("Krishi Vigyan Kendra").snippet("Jagatballavpur"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(22.899053, 88.371367)).title("Hooghly Krishi Vigyan Kendra").snippet("Hooghly"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(25.219341, 87.925496)).title("Krishi Vigyan Kendra").snippet("Malda"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(22.896392, 88.627500)).title("Krishi Vigyan Kendra").snippet("Dighalgram"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(23.290876, 87.402505)).title("Krishi Vigyan Kendra").snippet("Sonamukhi"));


        CameraPosition kgps = CameraPosition.builder().target(new LatLng(22.525497, 86.875132)).zoom(6).build();
        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(kgps));

    }
}

