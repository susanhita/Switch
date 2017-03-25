package com.habijabi.root.aswitch;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class DeviceActivity_old extends AppCompatActivity {
    String device_nameid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_old);
        Intent i = getIntent();

        int position = i.getExtras().getInt("id");
        Integer imageid = i.getExtras().getInt("imageId");
        device_nameid= i.getExtras().getString("device");


      //  ((TextView) findViewById(R.id.title)).setText(element.getTitle());
       // ((TextView) findViewById(R.id.description)).setText(element.getDescription());

        // if we transition the status and navigation bar we have to wait till everything is available
        //TransitionHelper.fixSharedElementTransitionForStatusAndNavigationBar(this);
        // set a custom shared element enter transition
      //  TransitionHelper.setSharedElementEnterTransition(this, R.transition.detail_activity_shared_element_enter_transition);
        ImageView mHeaderImageView = (ImageView) findViewById(R.id.imageView);
        mHeaderImageView.setImageResource(imageid);
        TextView mHeaderTitle = (TextView) findViewById(R.id.textView);
        mHeaderTitle.setText(device_nameid);

        ListView roomlist = (ListView) findViewById(R.id.devicelist);
        roomlist.setAdapter(new DeviceActivityAdapter(this));
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.explode);
        animation.setStartOffset(700);
        roomlist.startAnimation(animation);
        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        Intent intent0 = new Intent(DeviceActivity_old.this, LightActivity.class);
                        intent0.putExtra("name",device_nameid);
                        startActivity(intent0);
                       /* case 1:
                            Intent intent1 = new Intent(RoomActivity.this, FanActivity.class);
                            intent1.putExtra("name",nameid);
                        case 2:
                            Intent intent2 = new Intent(RoomActivity.this, ACActivity.class);
                            intent2.putExtra("name",nameid);
                        case 3:
                            Intent intent3 = new Intent(RoomActivity.this, LockActivity.class);
                            intent3.putExtra("name",nameid);
                        case 4:
                            Intent intent4 = new Intent(RoomActivity.this, CameraActivity.class);
                            intent4.putExtra("name",nameid);*/
                    default:
                        Toast.makeText(getApplicationContext(), "position" + i, Toast.LENGTH_SHORT).show();


                }


            }
        };
        roomlist.setOnItemClickListener(itemClickListener);
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