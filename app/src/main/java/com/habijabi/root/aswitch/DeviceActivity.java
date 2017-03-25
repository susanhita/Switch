package com.habijabi.root.aswitch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DeviceActivity extends AppCompatActivity {
    public static boolean light_status,fan_status,ac_status,lock_status;
    Button light,fan,ac,lock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device);
        light= (Button) findViewById(R.id.light1);
        ac= (Button) findViewById(R.id.ac);
        lock= (Button) findViewById(R.id.lock);
        fan = (Button) findViewById(R.id.fan);
        /*read from intent states of light, fans

        Intent intent=getIntent();
        light_status=intent.getExtras().getBoolean("lightStatus");
        fan_status=intent.getExtras().getBoolean("fanStatus");

        //fan = (Button) findViewById(R.id.fan1);

        */

        /*light= (Button) findViewById(R.id.light1);
        fan= (Button) findViewById(R.id.fan);
        ac= (Button) findViewById(R.id.ac);
        lock= (Button) findViewById(R.id.lock);

        if (!light_status)
            light.setBackgroundResource(R.drawable.bulboff);
        else
            light.setBackgroundResource(R.drawable.bulbon);

        if (!fan_status)
            fan.setBackgroundResource(R.drawable.fanoff1);
        else
            fan.setBackgroundResource(R.drawable.fanon1);

        if (!ac_status)
            ac.setBackgroundResource(R.drawable.acoff);
        else
            ac.setBackgroundResource(R.drawable.acon);

        if (!lock_status)
            lock.setBackgroundResource(R.drawable.lock_open);
        else
            lock.setBackgroundResource(R.drawable.lock1);

*/
    }

    public void LightonClick(View v) {
        if (lock_status)
            light.setBackgroundResource(R.drawable.bulboff);
        else {
            light.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.bulbon, 0, 0);
            light.setTextColor(0xFF29A403);
        }

    }

    public void AConClick(View v) {
        if (ac_status)
            ac.setBackgroundResource(R.drawable.acoff);
        else{
            ac.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.acon, 0, 0);
            ac.setTextColor(0xFF29A403);


        }
    }

    public void FanonClick(View v) {
        if (fan_status)
            fan.setBackgroundResource(R.drawable.fanon);
        else {
            fan.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.fanon, 0, 0);
            fan.setTextColor(0xFF29A403);
        }
    }

    public void LockonClick(View v) {
        if (lock_status)
            lock.setBackgroundResource(R.drawable.lock_open);
        else{
            lock.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.lock1, 0, 0);
            lock.setTextColor(0xFF29A403);
        }
    }
}
