package com.habijabi.root.aswitch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class LightActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light);
        Intent i = getIntent();
        final String room = i.getExtras().getString("name");
        TextView room_name=(TextView)findViewById(R.id.room_name);
        room_name.setText(room);

    }



}
