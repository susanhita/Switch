package com.habijabi.root.aswitch;


    import android.content.Intent;
    import android.os.Bundle;
    import android.support.v4.view.ViewCompat;
    import android.support.v7.app.AppCompatActivity;
    import android.util.Log;
    import android.widget.ImageView;
    import android.widget.TextView;
    import android.widget.Toolbar;

public class RoomActivity extends AppCompatActivity {
    public static  String VIEW_NAME_HEADER_IMAGE = "detail:header:image";

    // View name of the header title. Used for activity scene transitions
    public static  String VIEW_NAME_HEADER_TITLE = "detail:header:title";

    @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.inside_room_view);
          //  setSupportActionBar((Toolbar) findViewById(R.id.button1));



            // Get intent data
            Intent i = getIntent();

            // Selected image id
            int position = i.getExtras().getInt("id");
            Integer imageid=i.getExtras().getInt("imageId");
            String nameid=i.getExtras().getString("name");

//            imageView.setText(position);
            //imageView.setImageResource(imageAdapter.mThumbIds[position]);

        Log.v("here","lets see" +position);
        ImageView mHeaderImageView = (ImageView) findViewById(R.id.imageView);
        mHeaderImageView.setImageResource(imageid);
        ViewCompat.setTransitionName(mHeaderImageView, VIEW_NAME_HEADER_IMAGE);
        TextView mHeaderTitle = (TextView) findViewById(R.id.textView);
        mHeaderTitle.setText(nameid);
        ViewCompat.setTransitionName(mHeaderTitle, VIEW_NAME_HEADER_TITLE);
        }
    }