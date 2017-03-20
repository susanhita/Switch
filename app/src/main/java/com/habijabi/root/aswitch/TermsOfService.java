package com.habijabi.root.aswitch;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TermsOfService extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms_of_service);
        TextView textView =(TextView)findViewById(R.id.textView4);
        textView.setClickable(true);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        String text = "To use Dhitra, you must agree to the <a href='http://www.calm.com'> Terms of Services </a> and read the <a href='http://www.apartmenttherapy.com'> Privacy Policy. </a>";
        textView.setText(Html.fromHtml(text));

    }

    public void info(View view){
        Intent browserIntent=new Intent(this,WebViewActivity.class);
       // Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
        startActivity(browserIntent);
    }


    public void next(View view){
        Intent intent=new Intent(this,CreateUserStep2.class);
        startActivity(intent);
    }




}
