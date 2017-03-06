package com.habijabi.root.aswitch;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class CreateUserStep5 extends AppCompatActivity implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    GoogleApiClient mGoogleApiClient ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_create5);
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();


    }

    @Override
    protected void onStart() {
        super.onStart();

        if (mGoogleApiClient != null) {
            mGoogleApiClient.connect();
        }

    }

    public void getGPS(View view){

        LocationManager locationManager = (LocationManager)
        getSystemService(Context.LOCATION_SERVICE);
      //  LocationListener locationListener = new MyLocationListener();
        checkPermission();
      //  Criteria criteria = new Criteria();
    //    String provider = locationManager.getBestProvider(criteria, false);
       // Location location = locationManager.getLastKnownLocation(provider);

       // Location loc=locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
       // Location loc;
        Location loc=locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

        Geocoder gcd = new Geocoder(getBaseContext(), Locale.getDefault());
        List<Address> addresses;
        try {
            addresses = gcd.getFromLocation(loc.getLatitude(),
                    loc.getLongitude(), 1);
            if (addresses.size() > 0) {
                String address = addresses.get(0).getAddressLine(0);
                String address1="\n"+addresses.get(0).getAddressLine(1);
                String address2="\n"+addresses.get(0).getAddressLine(2);
                String address3="\n"+addresses.get(0).getAddressLine(3);
                EditText editText=(EditText) findViewById(R.id.gpsloc);

                editText.setVisibility(View.VISIBLE);

                editText.setText("Address:"+address+address1+address2+address3);



            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        // locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
       // locationManager.requestSingleUpdate(LocationManager.GPS_PROVIDER,11,null);
  }
    public void manual(View view){
        EditText editText5=(EditText)findViewById(R.id.editText5);
        //editText5.setVisibility(View.VISIBLE);
        EditText editText6=(EditText)findViewById(R.id.editText6);
       // editText6.setVisibility(View.VISIBLE);
        EditText editText7=(EditText)findViewById(R.id.editText7);
        //editText7.setVisibility(View.VISIBLE);
        EditText editText8=(EditText)findViewById(R.id.gpsloc);
       // editText8.setVisibility(View.INVISIBLE);//will changeeeeeeeeeeeeeeeeeeeeee this after testingggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg
        EditText test=(EditText)findViewById(R.id.test);

        checkPermission();
        Location mLastLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
        if (mLastLocation==null)
            Toast.makeText(getApplicationContext(),"null value",Toast.LENGTH_SHORT).show();
        else {

            Geocoder gcd = new Geocoder(getBaseContext(), Locale.getDefault());
            List<Address> addresses;
            try {
                addresses = gcd.getFromLocation(mLastLocation.getLatitude(),
                        mLastLocation.getLongitude(), 1);
                if (addresses.size() > 0) {
                    String address = addresses.get(0).getAddressLine(0);
                    String address1 = "\n" + addresses.get(0).getAddressLine(1);
                    String address2 = "\n" + addresses.get(0).getAddressLine(2);

                    String address3 = "\n" + addresses.get(0).getAddressLine(3);
                    //  EditText editText=(EditText) findViewById(R.id.gpsloc);

                    //  editText.setVisibility(View.VISIBLE);

                    test.setText("Address:" + address + address1 + address2 + address3);


                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public boolean checkPermission()
    {
        int currentAPIVersion = Build.VERSION.SDK_INT;
        if(currentAPIVersion>=android.os.Build.VERSION_CODES.M)
        {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                if (ActivityCompat.shouldShowRequestPermissionRationale((Activity) this, Manifest.permission.ACCESS_FINE_LOCATION)) {
                    AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
                    alertBuilder.setCancelable(true);
                    alertBuilder.setTitle("Permission necessary");
                    alertBuilder.setMessage("Access to GPS_PROVIDER is necessary to read QR code");
                    alertBuilder.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
                        public void onClick(DialogInterface dialog, int which) {
                            ActivityCompat.requestPermissions(CreateUserStep5.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 0);
                        }
                    });
                    AlertDialog alert = alertBuilder.create();
                    alert.show();

                } else {
                    ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 0);
                }
                return false;
            } else {
                return true;
            }
        } else {
            return true;
        }
    }
    @Override
    protected void onDestroy() {
        finish();
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    public void next1(View view){
        Intent intent=new Intent(this,CreateUserStep6.class);
        startActivity(intent);
    }
}

