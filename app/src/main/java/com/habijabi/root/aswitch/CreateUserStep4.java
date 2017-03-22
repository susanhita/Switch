package com.habijabi.root.aswitch;
/*Sending QR code, First name and Last name*/

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class CreateUserStep4 extends AppCompatActivity {
    String qr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_create4);
        overridePendingTransition(R.anim.transition,R.anim.transition_reverse);
        Intent intent=getIntent();
        qr=intent.getStringExtra("QRCode");

    }
    public void next(View view){
        EditText fName=(EditText)findViewById(R.id.firstName);
        EditText lName=(EditText)findViewById(R.id.lastName);
        Intent intent=new Intent(this,CreateUserStep5.class);
        intent.putExtra("firstname",fName.getText().toString());
        intent.putExtra("lastname",lName.getText().toString());
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
