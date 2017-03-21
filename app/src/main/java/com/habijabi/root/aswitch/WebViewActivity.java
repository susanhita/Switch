package com.habijabi.root.aswitch;

import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.webkit.WebView;

public class WebViewActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        overridePendingTransition(R.anim.transition,R.anim.transition_reverse);
        Log.v("yayyyyyyyyyyyyyyyy","reached yere");
        webView = (WebView) findViewById(R.id.webView1);
        webView.getSettings().setJavaScriptEnabled(true);
        //webView.loadUrl("http://www.abeautifulmess.com");
        if( savedInstanceState == null ) {
            String url =
                    getIntent().getDataString().replace("switch://", "http://");
            webView.loadUrl(url);

        }
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
