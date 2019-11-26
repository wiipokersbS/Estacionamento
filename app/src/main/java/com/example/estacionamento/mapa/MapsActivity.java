package com.example.estacionamento.mapa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.Manifest;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.estacionamento.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


//https://www.zoftino.com/android-show-current-location-on-map-example

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback{

    private GoogleMap mMap;
    private static  final int LOCALTION_REQUEST_CODE = 1;

    //LocationListener locationListener;
    // LocationManager locationManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostra_mapa);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);




    }

    /*public void onRequestPermissionsResult(int requestCode,  String[] permissions,
            int[] grantResult) {

        super.onRequestPermissionsResult(requestCode, permissions, grantResult);

        if (grantResult.length > 0 && grantResult[0] == PackageManager.PERMISSION_GRANTED) {

            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED) {

                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);

            }
        }
    }*/



    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


        mMap.setOnMyLocationButtonClickListener(onMyLocationButtonClickListener);
        mMap.setOnMyLocationClickListener(onMyLocationClickListener);
        enableMyLocationIfPermitted();

        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.setMinZoomPreference(11);


        // Add a marker in Sydney and move the camera
        // LatLng sydney = new LatLng(-34, 151);
        // mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        //  mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

     //   locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);

       /* locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {

                mMap.clear();

                LatLng userLocation = new LatLng(location.getLatitude(), location.getLongitude());

                mMap.addMarker(new MarkerOptions().position(userLocation).title("HERE I AM"));

                mMap.moveCamera(CameraUpdateFactory.newLatLng(userLocation));

             //   Toast.makeText(MapsActivity.this, userLocation.toString(),
                 //       Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        };*/

      /*  if (Build.VERSION.SDK_INT < 23) {

            if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    Activity#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for Activity#requestPermissions for more details.
                return;
            }
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);


        }*/ /*else
            if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
            == PackageManager.PERMISSION_GRANTED){

                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,0,0,locationListener);

                Location ultimaloc = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

                LatLng userLocation = new LatLng(ultimaloc.getLatitude(), ultimaloc.getLongitude());

                mMap.clear();

                mMap.addMarker(new MarkerOptions().position(userLocation).title("Marker"));

                mMap.moveCamera(CameraUpdateFactory.newLatLng(userLocation));

              //  Toast.makeText(MapsActivity.this, userLocation.toString(),
                   //     Toast.LENGTH_SHORT).show();
            }*/
         /*   else {

                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
            }*/


    }


    private void enableMyLocationIfPermitted() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                            Manifest.permission.ACCESS_FINE_LOCATION},
                    LOCALTION_REQUEST_CODE);
        } else if (mMap != null) {
            mMap.setMyLocationEnabled(true);
        }
    }


    private void showDefaultLocation() {
        Toast.makeText(this, "Permissão do acesso a localização negado, " +
                        "Mostrando localização default",
                Toast.LENGTH_SHORT).show();
        LatLng redmond = new LatLng(47.6739881, -122.121512);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(redmond));
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        switch (requestCode) {
            case LOCALTION_REQUEST_CODE: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    enableMyLocationIfPermitted();
                } else {
                    showDefaultLocation();
                }
                return;
            }

        }
    }

    private GoogleMap.OnMyLocationButtonClickListener onMyLocationButtonClickListener =
            new GoogleMap.OnMyLocationButtonClickListener() {
                @Override
                public boolean onMyLocationButtonClick() {
                    mMap.setMinZoomPreference(15);
                    return false;
                }
            };

    private GoogleMap.OnMyLocationClickListener onMyLocationClickListener =
            new GoogleMap.OnMyLocationClickListener() {
                @Override
                public void onMyLocationClick(@NonNull Location location) {

                    mMap.setMinZoomPreference(12);

                    MarkerOptions markerOptions = new MarkerOptions();


                    mMap.addMarker(markerOptions.position(new LatLng(location.getLatitude(),
                            location.getLongitude())).title("Estacionamento")
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));




                    // CustomWindowInfo customWindowInfo = new CustomWindowInfo();

                   // mMap.setInfoWindowAdapter(customWindowInfo);


                  //  InfoWindowData infoWindowData = new InfoWindowData();

                 //   infoWindowData.setImage("imagem");
                 //   infoWindowData.setHotel("Hotel");
                 //   infoWindowData.setFood("Foodos");
                 //   infoWindowData.setTransport("trans");

                  //  CustomWindowInfo customWindowInfo = new CustomWindowInfo(this);

               //     mMap.setInfoWindowAdapter(customWindowInfo);

                 //   Marker marker = null;
                  //  marker.setTag(infoWindowData);
                 //   marker.showInfoWindow();

                  //  mMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(location.getLatitude(),
                   //         location.getLongitude())));

                  //  CircleOptions circleOptions = new CircleOptions();
                   // circleOptions.center(new LatLng(location.getLatitude(),
                     //       location.getLongitude()));

                    //circleOptions.radius(200);
                    //circleOptions.fillColor(Color.RED);
                    //circleOptions.strokeWidth(6);

                    //mMap.addCircle(circleOptions);

                  //  circleOptions.isClickable();



                }
            };




    }
