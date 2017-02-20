package com.habijabi.root.aswitch;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;

/**
 * Created by root on 14/2/17.
 */





    import android.content.Context;
    import android.view.LayoutInflater;
    import android.view.View;
    import android.view.ViewGroup;
    import android.widget.BaseAdapter;
    import android.widget.ImageView;
    import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import static com.habijabi.root.aswitch.R.id.screen_shot;

public class RoomButtonAdapter extends BaseAdapter {

        private LayoutInflater layoutinflater;
        private List<ItemObject> listStorage;
        public Context context;

        public RoomButtonAdapter(Context context, List<ItemObject> customizedListView) {
            this.context = context;
            layoutinflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            listStorage = customizedListView;
        }

        @Override
        public int getCount() {
            return listStorage.size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position,   View convertView, ViewGroup parent) {

            final ViewHolder listViewHolder;
            if(convertView == null){
                listViewHolder = new ViewHolder();
                convertView = layoutinflater.inflate(R.layout.room_item_list, parent, false);
                listViewHolder.screenShot = (ImageView)convertView.findViewById(screen_shot);
                listViewHolder.musicName = (TextView)convertView.findViewById(R.id.music_name);
                //listViewHolder.musicAuthor = (TextView)convertView.findViewById(R.id.music_author);

                convertView.setTag(listViewHolder);
            }else{
                listViewHolder = (ViewHolder)convertView.getTag();
            }
            listViewHolder.screenShot.setImageResource(listStorage.get(position).getScreenShot());
            listViewHolder.musicName.setText(listStorage.get(position).getMusicName());
          //  listViewHolder.musicAuthor.setText(listStorage.get(position).getMusicAuthor());
            convertView.setOnClickListener(new AdapterView.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub


                    Intent intent = new Intent(context, RoomActivity.class);
                    intent.putExtra("id", position);
                    intent.putExtra("name",listStorage.get(position).getMusicName());
                    intent.putExtra("imageId",listStorage.get(position).getScreenShot());

                    ActivityOptionsCompat options = ActivityOptionsCompat.
                            makeSceneTransitionAnimation((Activity)context, listViewHolder.screenShot, "profile");

                    context.startActivity(intent, options.toBundle());
                   // context.startActivity(intent);



                }
        });
            return convertView;
        }



        static class ViewHolder{
            ImageView screenShot;
            TextView musicName;
            TextView musicAuthor;
        }
    }

