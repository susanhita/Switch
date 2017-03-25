package com.habijabi.root.aswitch;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import java.net.URI;
import java.net.URISyntaxException;


public class CreateUserStep9 extends AppCompatActivity {
    EditText mobilenum, countrycode;
    WebSocketClient mWebSocketClient;
    String qr,firstname,lastname,address,phone;//To be Obtained from previous intent

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_create9);
        overridePendingTransition(R.anim.transition,R.anim.transition_reverse);
        Intent intent=getIntent();
        qr=intent.getStringExtra("QRCode");
        firstname=intent.getStringExtra("firstname");
        lastname=intent.getStringExtra("lastname");
        address=intent.getStringExtra("address");
        phone=intent.getStringExtra("phone");
        connectWebSocket();
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

    public void submit(View view){
        EditText editText = (EditText)findViewById(R.id.message);
        String str="<b><p>"+randText()+"</b><p>";
    //    Log.v("susanhita",str);

        mWebSocketClient.send(editText.getText().toString()+"<br><b>QR code:</b>"+qr+"<br><b>Name:</b>"+firstname+" "+lastname+"<br><b>Phone:</b>"+phone+"<br><b>Address</b>"+address);
        editText.setText("");
    }

    private void connectWebSocket() {
        URI uri;
        try {
            uri = new URI("ws://echo.websocket.org");
           // uri = new URI("ws://sandbox.kaazing.net/echo");
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return;
        }

         mWebSocketClient = new WebSocketClient(uri) {
            @Override
            public void onOpen(ServerHandshake serverHandshake) {
                Log.i("Websocket", "Opened");
                mWebSocketClient.send("Hello from " + Build.MANUFACTURER + " " + Build.MODEL);
            }

            @Override
            public void onMessage(String s) {
                final String message = s;
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        TextView textView = (TextView)findViewById(R.id.messages);
                        textView.setText("");
                        textView.setText(Html.fromHtml(textView.getText() + "\n" + message));
                    }
                });
            }

            @Override
            public void onClose(int i, String s, boolean b) {
                Log.i("Websocket", "Closed " + s);
            }

            @Override
            public void onError(Exception e) {
                Log.i("Websocket", "Error " + e.getMessage());
            }
        };
        mWebSocketClient.connect();
    }
    public String randText()
    {
        String[] str={ "Hail ","May the force be with you. ", "You are awesome you know! ", "You may be a fool and you do not know it for sure. ", "Don't give up on your dreams. Keep sleeping always. ","I may not be perfect, but at least I am not you. ",
                "It is true.Beautiful things have dents and scratches too. ", "Make peace with your past,so that it doesnt spoil your present.","To the question ‘What are you doing here?’ 72% answered negative.","Marriage is the main reason for divorce.",
                "Artificial intelligence would never substitute the natural stupidity.","Have you noticed that in cartoons gravity does not work until you look down" };
        int randomNum = 0 + (int)(Math.random() * str.length);
        return str[randomNum];

    }

    public void next(View view){
        Intent intent=new Intent(this,CreateSetup.class);
        startActivity(intent);
    }

}

