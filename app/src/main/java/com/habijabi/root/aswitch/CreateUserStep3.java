package com.habijabi.root.aswitch;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;

public class CreateUserStep3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_create3);
        overridePendingTransition(R.anim.transition,R.anim.transition_reverse);
        TextView textView =(TextView)findViewById(R.id.textView4);
        textView.setClickable(true);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        String text = "To use Dhitra, you must agree to the <a href='switch://www.seventeen.com'> Terms of Services</a>";
        textView.setText(Html.fromHtml(text));

        TextView privacy =(TextView)findViewById(R.id.privacy);
        privacy.setClickable(true);
        privacy.setMovementMethod(LinkMovementMethod.getInstance());
        String priv = "and read the <a href='switch://www.apartmenttherapy.com'> Privacy Policy </a>";
        privacy.setText(Html.fromHtml(priv));

    }

    public void info(View view){
        Intent browserIntent=new Intent(this,WebViewActivity.class);
        browserIntent.setData(Uri.parse("switch://www.abeautifulmess.com"));
        startActivity(browserIntent);
    }


    public void next(View view){
        Intent intent=new Intent(this,CreateUserStep4.class);
        startActivity(intent);
    }




}
