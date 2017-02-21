package com.habijabi.root.aswitch;

import android.animation.Animator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.support.transition.Transition;
import android.support.transition.TransitionManager;
import android.support.v4.app.ActivityOptionsCompat;
import android.transition.Explode;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
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

import static android.R.transition.explode;
import static com.habijabi.root.aswitch.R.id.grid_item_image;
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
                    Animator animator = ViewAnimationUtils.createCircularReveal(
                            v,
                            v.getWidth()/2,
                            v.getHeight()/2,
                            v.getWidth(),
                            0);
                    animator.setInterpolator(new AccelerateDecelerateInterpolator());
                    animator.setDuration(2000);
                    animator.start();

                Intent intent = new Intent(context, RoomActivity.class);
                    intent.putExtra("id", position);
                    intent.putExtra("name",listStorage.get(position).getMusicName());
                    intent.putExtra("imageId",listStorage.get(position).getScreenShot());
                    final Rect viewRect = new Rect();
                    v.getGlobalVisibleRect(viewRect);


                    v.getGlobalVisibleRect(viewRect);

                    // create Explode transition with epicenter
                    final View rect = listViewHolder.screenShot;
                    rect.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Animator animator = ViewAnimationUtils.createCircularReveal(
                                    rect,
                                    0,
                                    0,
                                    0,
                                    (float) Math.hypot(rect.getWidth(), rect.getHeight()));
                            animator.setInterpolator(new AccelerateInterpolator());
                            animator.setDuration(2000);
                            animator.start();
                        }
                    });






                  //    ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity)context, listViewHolder.screenShot, "profile");
                   // ActivityOptionsCompat options = ActivityOptionsCompat.makeScaleUpAnimation(listViewHolder.screenShot,0,0,0,0);
                   //context.startActivity(intent, options.toBundle());
                    context.startActivity(intent);



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

