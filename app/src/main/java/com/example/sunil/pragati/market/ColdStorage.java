package com.example.sunil.pragati.market;

        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.support.v7.widget.Toolbar;
        import android.view.View;

        import com.example.sunil.pragati.R;
        import com.google.android.gms.maps.CameraUpdateFactory;
        import com.google.android.gms.maps.GoogleMap;
        import com.google.android.gms.maps.MapView;
        import com.google.android.gms.maps.MapsInitializer;
        import com.google.android.gms.maps.OnMapReadyCallback;
        import com.google.android.gms.maps.model.CameraPosition;
        import com.google.android.gms.maps.model.LatLng;
        import com.google.android.gms.maps.model.MarkerOptions;

public class ColdStorage extends AppCompatActivity implements OnMapReadyCallback {


    GoogleMap googleMap;
    MapView mapView;
    View mView;
    private static final LatLng Kgp = new LatLng(22.525497, 86.875132);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cold_storage);


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
        googleMap.addMarker(new MarkerOptions().position(new LatLng(22.407271, 87.742458)).title("Panskura Cold Storage").snippet("Panskura"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(22.579124, 87.718044)).title("Cold Storage").snippet(" Baikunthapur"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(22.844500, 87.342390)).title("Amlagora Cold Storage (P) Ltd.").snippet("Amlagora"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(22.846185, 87.337428)).title("Garhbeta Ice & Cold Storage Pvt. Ltd.").snippet("Amlagora"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(22.856705, 87.343849)).title("Radhanagar Cold Storage Pvt Ltd").snippet("Amlagora"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(22.900420, 87.219494)).title("Karnimata Cold Storage Limited").snippet("Jogerdanga"));


        CameraPosition kgps = CameraPosition.builder().target(new LatLng(22.844500, 87.342390)).zoom(7).build();
        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(kgps));

    }
}
