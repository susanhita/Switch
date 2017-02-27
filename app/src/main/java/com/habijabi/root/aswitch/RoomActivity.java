package com.habijabi.root.aswitch;


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

    @Override
    public void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS);

        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_room);


        // Get intent data
        Intent i = getIntent();

        // Selected image id
        final int position = i.getExtras().getInt("id");
        Integer imageid = i.getExtras().getInt("imageId");
        String nameid = i.getExtras().getString("name");

//            imageView.setText(position);
        //imageView.setImageResource(imageAdapter.mThumbIds[position]);

        Log.v("here", "lets see" + position);
        ImageView mHeaderImageView = (ImageView) findViewById(R.id.imageView);
        mHeaderImageView.setImageResource(imageid);
        TextView mHeaderTitle = (TextView) findViewById(R.id.textView);
        mHeaderTitle.setText(nameid);
      //  String[] mobileArray = {"Lights", "Fans", "AC", "TV", "Camera", "Locks"};
      //  ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.room_activity_list, mobileArray);
        //DeviceButtonAdapter adapter = new DeviceButtonAdapter(this);


        ListView roomlist = (ListView) findViewById(R.id.roomlist);
        roomlist.setAdapter(new RoomActivityAdapter(this));
        Animation animation2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.explode);
        animation2.setStartOffset(700);
        roomlist.startAnimation(animation2);
        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                     Toast.makeText(getApplicationContext(), "position" + i, Toast.LENGTH_SHORT).show();
            }
        };
        roomlist.setOnItemClickListener(itemClickListener);


    }


}

