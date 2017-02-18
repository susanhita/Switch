package com.habijabi.root.aswitch;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;

/**
 * Created by root on 14/2/17.
 */

public class RoomButtonAdapter extends BaseAdapter {




    private Context mContext;
    LayoutInflater inflater;
    int roomlayout;


    // Constructor
    public RoomButtonAdapter(Context c,int layoutResourceId) {
        roomlayout=layoutResourceId;
        mContext = c;
        inflater = (LayoutInflater) this.mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }




    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        final Button button;

        if (convertView == null) {
            convertView = inflater.inflate(roomlayout, null);

            button = new Button(mContext);
            button.setLayoutParams(new GridView.LayoutParams(250, 250));//this is the height,wodth of the images


        }
        else
        {
            button = (Button) convertView;
        }
        button.setBackgroundResource(mThumbIds[position]);
        //      button.setCompoundDrawablesWithIntrinsicBounds(0, mThumbIds[position],0,0);
        button.setText(mStringIds[position]);
        button.setFocusable(false);
        button.setFocusableInTouchMode(false);
        button.setClickable(false);
        button.setTransitionName("profile");
        button.setId(position);
// inside your activity (if you did not enable transitions in your theme)


        return button;
    }

    // Keep all Images in array
    public Integer[] mThumbIds = {
            R.drawable.bedroom, R.drawable.bedroom2,
            R.drawable.dining, R.drawable.kitchen,
            R.drawable.balcony, R.drawable.bathroom

    };
    public String[] mStringIds = {
            "Bedroom", "Bedroom2",
            "Dining","Kitchen",
            "Balcony", "Bathroom"

    };

}