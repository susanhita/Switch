package com.habijabi.root.aswitch;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static com.habijabi.root.aswitch.R.id.imageView2;
import static com.habijabi.root.aswitch.R.id.label;

/**
 * Created by root on 25/2/17.
 */


public class RoomActivityAdapter extends BaseAdapter {
    private List<ItemObject> getAllDeviceItemObject() {
        List<ItemObject> items = new ArrayList<>();
        items.add(new ItemObject(R.drawable.lights, "Lights", "sunny"));
        items.add(new ItemObject(R.drawable.fan, "Fans", "Adele Adkins"));
        items.add(new ItemObject(R.drawable.ac, "AC", "Ciara"));
        items.add(new ItemObject(R.drawable.lock, "Locks", "Bedroom"));
        items.add(new ItemObject(R.drawable.camera, "Cameras", "Room"));
        return items;

    }

    private LayoutInflater layoutinflater;
    public List<ItemObject> allroomlist=getAllDeviceItemObject() ;
    public Context context;

    public RoomActivityAdapter(Context context ) {
        this.context = context;
        this.layoutinflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public int getCount() {
        return allroomlist.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = layoutinflater.inflate(R.layout.room_activity_list, parent, false);
            ImageView imageView = (ImageView)convertView.findViewById(imageView2);
            imageView.setImageResource(allroomlist.get(position).getScreenShot());

            TextView textView=(TextView)convertView.findViewById(label);
            textView.setText(allroomlist.get(position).getMusicName());

        }
        return convertView;
    }
}