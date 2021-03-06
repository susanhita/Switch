package com.habijabi.root.aswitch;


    import android.app.ActionBar;
    import android.content.Context;
    import android.content.Intent;
    import android.os.Bundle;
    import android.support.v4.view.ViewCompat;
    import android.support.v7.app.AppCompatActivity;
    import android.transition.Explode;
    import android.transition.Fade;
    import android.transition.Slide;
    import android.transition.TransitionInflater;
    import android.util.Log;
    import android.view.LayoutInflater;
    import android.view.MenuItem;
    import android.view.View;
    import android.view.ViewGroup;
    import android.view.Window;
    import android.view.animation.Animation;
    import android.view.animation.AnimationUtils;
    import android.widget.AdapterView;
    import android.widget.ArrayAdapter;
    import android.widget.BaseAdapter;
    import android.widget.ImageView;
    import android.widget.ListView;
    import android.widget.TextView;
    import android.widget.Toast;

    import java.util.ArrayList;
    import java.util.List;

    import static com.habijabi.root.aswitch.R.id.device_icon;
    import static com.habijabi.root.aswitch.R.id.image;
    import static com.habijabi.root.aswitch.R.id.imageView;
    import static com.habijabi.root.aswitch.R.id.imageView2;
    import static com.habijabi.root.aswitch.R.id.label;

public class RoomActivity extends AppCompatActivity {
    public static String VIEW_NAME_HEADER_IMAGE = "detail:header:image";

    // View name of the header title. Used for activity scene transitions
    public static String VIEW_NAME_HEADER_TITLE = "detail:header:title";
    ImageView mHeaderImageView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS);

        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_room);
        ActionBar actionBar=getActionBar();

        Intent i = getIntent();

        // Selected image id
        final int position = i.getExtras().getInt("id");
        Integer imageid = i.getExtras().getInt("imageId");
        final String nameid = i.getExtras().getString("name");
        Log.v("here", "lets see" + position);
        mHeaderImageView = (ImageView) findViewById(R.id.imageView);
        mHeaderImageView.setImageResource(imageid);
        TextView mHeaderTitle = (TextView) findViewById(R.id.textView);
        mHeaderTitle.setText(nameid);
        ListView roomlist = (ListView) findViewById(R.id.roomlist);
        roomlist.setAdapter(new RoomActivityAdapter(this));
        Animation animation2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.explode);
        animation2.setStartOffset(700);
        roomlist.startAnimation(animation2);
        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    switch (i){
                        case 0:
                            Intent intent0 = new Intent(RoomActivity.this, LightActivity.class);
                            intent0.putExtra("name",nameid);
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

    public void onBackPressed() {
        Animation animation2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_reverse);
        animation2.setStartOffset(200);

        mHeaderImageView.startAnimation(animation2);

        super.onBackPressed();
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

