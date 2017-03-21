package com.habijabi.root.aswitch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class CreateUserStep7 extends AppCompatActivity {
    String qr,firstname,lastname,address,phone,email;//To be Obtained from previous intent

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
        email=intent.getStringExtra("email");
    }

    public void verify(View view){
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioVerify);
        RadioButton rb = (RadioButton) radioGroup.findViewById(radioGroup.getCheckedRadioButtonId())   ;
       /*email*/
        if (rb.getText()==email) {
            Intent i = new Intent(Intent.ACTION_SEND);
            i.setType("text/plain");
            i.putExtra(Intent.EXTRA_EMAIL, new String[]{email});
            i.putExtra(Intent.EXTRA_SUBJECT, "subject of email");
            i.putExtra(Intent.EXTRA_TEXT, "body of email");
            try {
                startActivity(Intent.createChooser(i, "Send mail..."));
            } catch (android.content.ActivityNotFoundException ex) {
                Toast.makeText(CreateUserStep7.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
            }
        }
        else
            /*phone*/
        {

        }
    }

    public void next(View view){
        Intent intent=new Intent(this,CreateUserStep8.class);
        intent.putExtra("firstname",firstname);
        intent.putExtra("lastname",lastname);
        intent.putExtra("address",address);
        intent.putExtra("phone",phone);
        intent.putExtra("QRCode",qr);
        intent.putExtra("email",email);
        startActivity(intent);
    }

    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.coming_in, R.anim.coming_out);
    }
}
