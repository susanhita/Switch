package com.habijabi.root.aswitch;

import android.content.Context;
import android.view.Gravity;
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
    Integer[] imageId;
    String[] nameId;


    // Constructor
    public RoomButtonAdapter(Context c,int layoutResourceId,Integer image_id[],String name_id[]) {
        imageId=image_id;
        nameId=name_id;
        roomlayout=layoutResourceId;
        mContext = c;
        inflater = (LayoutInflater) this.mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    public int getCount() {
        return nameId.length;
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
            button.setLayoutParams(new GridView.LayoutParams(250, 300));//this is the height,wodth of the images
            button.setElegantTextHeight(true);

        }
        else
        {
            button = (Button) convertView;
        }
        button.setBackgroundResource(imageId[position]);
        button.setPadding(0,10,0,0);
      // button.setCompoundDrawablesWithIntrinsicBounds(0,imageId[position],0,0);
        button.setText(nameId[position]);
        button.setGravity(Gravity.TOP);
        button.setFocusable(false);
        button.setFocusableInTouchMode(false);
        button.setClickable(false);
        button.setId(position);
// inside your activity (if you did not enable transitions in your theme)


        return button;
    }

    // Keep all Images in array


}