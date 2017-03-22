package com.habijabi.root.aswitch;
/*Sending First name, Last name , Address and Phone number*/

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.hbb20.CountryCodePicker;

public class CreateUserStep6 extends AppCompatActivity {
    int index;
    CountryCodePicker ccp;
    String qr,firstname,lastname,address;//To be Obtained from previous intent


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent=getIntent();
        String country_code=intent.getStringExtra("country_code");
        String countryName=intent.getStringExtra("country");
        firstname=intent.getStringExtra("firstname");
        lastname=intent.getStringExtra("lastname");
        address=intent.getStringExtra("address");
        qr=intent.getStringExtra("QRCode");
        Log.v("code",country_code);
        Log.v("country",countryName);
        setContentView(R.layout.user_create6);
        overridePendingTransition(R.anim.transition,R.anim.transition_reverse);
        ccp = (CountryCodePicker) findViewById(R.id.ccp);

        if (!countryName.contentEquals("")) {
            ccp.setDefaultCountryUsingNameCode(country_code);
            ccp.resetToDefaultCountry();
            EditText carrierNumberEditText=(EditText)findViewById(R.id.carrierNumberEditText);
            ccp.registerCarrierNumberEditText(carrierNumberEditText);
        }

    }
    public void next(View view){
        String phone=ccp.getFullNumber();
        Intent intent=new Intent(this,CreateUserStep7.class);
        intent.putExtra("firstname",firstname);
        intent.putExtra("lastname",lastname);
        intent.putExtra("address",address);
        intent.putExtra("phone",phone);
        intent.putExtra("QRCode",qr);
        startActivity(intent);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.coming_in, R.anim.coming_out);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }

        return(super.onOptionsItemSelected(item));
    }

}
