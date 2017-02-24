package com.habijabi.root.aswitch;


import android.content.Intent;
import android.os.Bundle;
import android.renderscript.Element;
import android.support.transition.Fade;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.transition.Slide;
import android.util.Log;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

public class DeviceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device);

       // setSupportActionBar((Toolbar) findViewById(R.id.toolbar));

      //  long elementId = getIntent().getLongExtra("ITEM_ID", -1);
       // Element element = DataSet.find(elementId);
        Intent i = getIntent();

        int position = i.getExtras().getInt("id");
        Integer imageid = i.getExtras().getInt("imageId");
        String nameid = i.getExtras().getString("name");
      //  ((TextView) findViewById(R.id.title)).setText(element.getTitle());
       // ((TextView) findViewById(R.id.description)).setText(element.getDescription());

        // if we transition the status and navigation bar we have to wait till everything is available
        //TransitionHelper.fixSharedElementTransitionForStatusAndNavigationBar(this);
        // set a custom shared element enter transition
      //  TransitionHelper.setSharedElementEnterTransition(this, R.transition.detail_activity_shared_element_enter_transition);
        ImageView mHeaderImageView = (ImageView) findViewById(R.id.imageView);
        mHeaderImageView.setImageResource(imageid);
        TextView mHeaderTitle = (TextView) findViewById(R.id.textView);
        mHeaderTitle.setText(nameid);
    }
}