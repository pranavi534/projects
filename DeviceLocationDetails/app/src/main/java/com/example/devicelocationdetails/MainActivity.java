package com.example.devicelocationdetails;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MainActivity extends FragmentActivity implements OnMapReadyCallback {
    TextView tv;
    FusedLocationProviderClient locationProviderClient;
    GoogleMap map;
    LocationManager locationManager;
    SupportMapFragment fragment;
    double lat, lon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.textView);
        locationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        LocationListener locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(@NonNull Location location) {
                lat = location.getLatitude();
                lon = location.getLongitude();
                fragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
                assert fragment != null;
                fragment.getMapAsync(MainActivity.this);
                locationProviderClient = LocationServices.getFusedLocationProviderClient(MainActivity.this);
            }
        };
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1, 1, locationListener);
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,1,1,locationListener);
    }

    public void getDeviceLocatipnDetails(View view) {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        locationProviderClient.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() {
            @Override
            public void onComplete(@NonNull Task<Location> task) {
                Location location = task.getResult();
                Geocoder geocoder = new Geocoder(MainActivity.this, Locale.getDefault());
                List<Address> addresses = null;
                try {
                    addresses = geocoder.getFromLocation(location.getLatitude(),location.getLongitude(),1);
                    String latitude = String.valueOf(addresses.get(0).getLatitude());
                    String longitude = String.valueOf(addresses.get(0).getLongitude());
                    String countryNames = String.valueOf(addresses.get(0).getCountryName());
                    String countryCodes = String.valueOf(addresses.get(0).getCountryCode());
                    String locality = String.valueOf(addresses.get(0).getLocality());
                    String Addresses = String.valueOf(addresses.get(0).getAddressLine(0));
                    String postalCode = String.valueOf(addresses.get(0).getPostalCode());
                    tv.setText("Latitude :"+latitude+"\n"+"Longitude :"+longitude+"\n"+"Country Name :"
                            +countryNames+"\n"+"Country Code :"+countryCodes+"\n"+"Locality :"+locality+"\n"+
                            "Addresses :"+addresses+"\n"+"Postal Code :"+postalCode);

                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        });



    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        BitmapDescriptor descriptor = BitmapDescriptorFactory.fromResource(R.drawable.ic_baseline_location_on_24);
        LatLng latLng  =new LatLng(lat,lon);
        map.clear();
        map.addMarker(new MarkerOptions().position(latLng).title("My Home").icon(descriptor));
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng,15.0f));
        map.getUiSettings().setZoomControlsEnabled(true);

    }
}

