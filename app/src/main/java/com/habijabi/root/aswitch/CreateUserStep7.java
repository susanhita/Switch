package com.habijabi.root.aswitch;
/*Sending First name, Last name , Address, Phone number and email*/

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CreateUserStep7 extends AppCompatActivity {
    String qr,firstname,lastname,address,phone;//To be Obtained from previous intent

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_create7);
        overridePendingTransition(R.anim.transition,R.anim.transition_reverse);
        Intent intent=getIntent();
        firstname=intent.getStringExtra("firstname");
        lastname=intent.getStringExtra("lastname");
        address=intent.getStringExtra("address");
        qr=intent.getStringExtra("QRCode");
        phone=intent.getStringExtra("phone");

    }


    public void next(View view){
        EditText email1=(EditText) findViewById(R.id.email);
        String email=email1.getText().toString();
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Toast.makeText(getApplicationContext(), "Please enter valid email id", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent intent = new Intent(this, CreateUserStep8.class);
        intent.putExtra("firstname", firstname);
        intent.putExtra("lastname", lastname);
        intent.putExtra("address", address);
        intent.putExtra("phone", phone);
        intent.putExtra("QRCode", qr);
        intent.putExtra("email", email);
        startActivity(intent);
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
