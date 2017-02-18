package com.habijabi.root.aswitch;

import android.app.Activity;

import android.content.Intent;

import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.util.Pair;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    /**
     * The {@link PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);/*BACKGROUND OF MAINPAGE CONTAINING ROOMVIEW,FAVEVIEW AND DEVICE VIEW]*/

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.container);/*PLACE CONTATING THE 3 VIEWS ROOM,DEVICE AND FAVE*/
        mViewPager.setAdapter(mSectionsPagerAdapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);/*THE SLIDABLE TABS*/
        tabLayout.setupWithViewPager(mViewPager);
        /***********THIS IS THE MAIL ICON AT THE BOTTOM***************/
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }


    public static class PlaceholderFragment extends Fragment {

        private List<ItemObject> getAllItemObject() {
            List<ItemObject> items = new ArrayList<>();
            items.add(new ItemObject(R.drawable.balcony, "Balcony", "sunny"));
            items.add(new ItemObject(R.drawable.bathroom, "Bathroom", "Adele Adkins"));
            items.add(new ItemObject(R.drawable.bedroom, "Bedroom", "Ciara"));
            items.add(new ItemObject(R.drawable.bedroom2, "Second", "Bedroom"));
            items.add(new ItemObject(R.drawable.dining, "Dining", "Room"));
            items.add(new ItemObject(R.drawable.kitchen, "Kitchen", "Food"));
            return items;

        }

        private static final String ARG_SECTION_NUMBER = "section_number";/*1 2 OR 3 CORSPONDING TO FAVE ROOM AND DEVICE*/
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

        public PlaceholderFragment() {
        }


        public static PlaceholderFragment newInstance(int sectionNumber) {/*RETURNS THE CORRESPONDING FRAGMENT ROOM,DEVICE OR FAVE*/
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }


        private RoomButtonAdapter mGridAdapter;


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {/*INFLATING EACH FRAGMENT*/
            switch (getArguments().getInt(ARG_SECTION_NUMBER)) {

                case 2: {/*ROOM FRAGMENT VIEW*/
                    final View rootView = inflater.inflate(R.layout.case_room_fragment, container, false);/*rootview is the room_fragment*/
                    final GridView gridView = (GridView) rootView.findViewById(R.id.gridView);/*new layout gridview for fragment=2 ie inside room_fragment*/
                    final Activity act = getActivity();
                    final RoomButtonAdapter myAdapter = new RoomButtonAdapter(act,R.layout.grid_item_layout,mThumbIds,mStringIds);/*set of buttons for  grid*/
                    gridView.setAdapter(myAdapter);
                    gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                        public void onItemClick(AdapterView<?> parent,
                                                final View v, final int position, long id) {/*click->transition->roomactivity*/

                            Intent intent = new Intent(act, RoomActivity.class);
                            intent.putExtra("id", position);
                            intent.putExtra("name",mStringIds[position]);
                            intent.putExtra("imageId",mThumbIds[position]);


                            startActivity(intent);
                        }});
                            /********CREATE ANIMATION HERE AND BUNDLE IT TO b********************************************************************************************************/

                           /*

                            Bundle b = ActivityOptionsCompat.makeSceneTransitionAnimation(act, transitionPairs).toBundle();
                            ActivityCompat.startActivity(act, intent, b);

                        }

                            /********CREATE ANIMATION HERE AND BUNDLE IT TO b********************************************************************************************************/


                    return rootView;

                }


                case 1: {


                    View rootView1 = inflater.inflate(R.layout.case_default_fragment, container, false);
                    TextView textView1 = (TextView) rootView1.findViewById(R.id.section_label);
                    textView1.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
                    return rootView1;
                }

                case 3: {/*DEVICE FRAGMENT VIEW*/


                    View view = inflater.inflate(R.layout.case_device_fragment, container, false);
                    GridView gridview = (GridView)view.findViewById(R.id.gridview);

                    List<ItemObject> allItems = getAllItemObject();
                    DeviceButtonAdapter customAdapter = new DeviceButtonAdapter(getActivity(), allItems);
                    gridview.setAdapter(customAdapter);

                    gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Toast.makeText(getActivity(), "Position: " + position, Toast.LENGTH_SHORT).show();
                        }
                    });
                    return view;

                }
                default: {
                    View rootView = inflater.inflate(R.layout.case_default_fragment, container, false);
                    TextView textView = (TextView) rootView.findViewById(R.id.section_label);
                    textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
                    return rootView;
                }
            }

        }
    }


    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Favorites";
                case 1:
                    return "Room View";
                case 2:
                    return "Device View";
            }
            return null;
        }
    }


}
