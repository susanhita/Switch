package com.habijabi.root.aswitch;

import android.net.Uri;
import android.os.Build;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;

import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.view.Window;
import android.view.WindowManager;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    private GoogleApiClient client;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS);
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);/*BACKGROUND OF MAINPAGE CONTAINING ROOMVIEW,FAVEVIEW AND DEVICE VIEW]*/
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.container);/*PLACE CONTATING THE 3 VIEWS ROOM,DEVICE AND FAVE*/
        mViewPager.setAdapter(mSectionsPagerAdapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);/*THE SLIDABLE TABS*/
        tabLayout.setupWithViewPager(mViewPager);


        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

    }


    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        item.setVisible(true);
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

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
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }


    public static class PlaceholderFragment extends Fragment {

        private List<ItemObject> getAllRoomItemObject() {
            List<ItemObject> items = new ArrayList<>();
            items.add(new ItemObject(R.drawable.balcony, "Balcony", "sunny"));
            items.add(new ItemObject(R.drawable.kitchen, "Kitchen", "Food"));
            items.add(new ItemObject(R.drawable.bathroom, "Bathroom", "Adele Adkins"));
            items.add(new ItemObject(R.drawable.bedroom, "Bedroom", "Ciara"));
            items.add(new ItemObject(R.drawable.bedroom2, "Second", "Bedroom"));
            items.add(new ItemObject(R.drawable.dining, "Dining", "Room"));
            return items;

        }

        private List<ItemObject> getAllDeviceItemObject() {
            List<ItemObject> items = new ArrayList<>();
            items.add(new ItemObject(R.drawable.device1, "Device 1", "sunny"));
            items.add(new ItemObject(R.drawable.device1, "Device 2", "Adele Adkins"));
            items.add(new ItemObject(R.drawable.device1, "Device 3", "Ciara"));
            items.add(new ItemObject(R.drawable.device1, "Device 4", "Bedroom"));
            items.add(new ItemObject(R.drawable.device1, "Device 5", "Room"));
            items.add(new ItemObject(R.drawable.device1, "Device 6", "Food"));
            return items;

        }

        private static final String ARG_SECTION_NUMBER = "section_number";/*1 2 OR 3 CORSPONDING TO FAVE ROOM AND DEVICE*/
        public Integer[] mThumbIds = {
                R.drawable.bedroom, R.drawable.bedroom2,
                R.drawable.dining, R.drawable.kitchen,
                R.drawable.balcony, R.drawable.bathroom

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


        private MainDeviceButtonAdapter mGridAdapter;


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {/*INFLATING EACH FRAGMENT*/
            switch (getArguments().getInt(ARG_SECTION_NUMBER)) {

                case 1: {


                    View rootView1 = inflater.inflate(R.layout.case_default_fragment, container, false);
                    TextView textView1 = (TextView) rootView1.findViewById(R.id.section_label);
                    textView1.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
                    return rootView1;
                }

                case 2: {/*device FRAGMENT VIEW*/
                    final View view = inflater.inflate(R.layout.case_device_fragment, container, false);/*rootview is the room_fragment*/
                    ListView listView = (ListView) view.findViewById(R.id.listView);/*new layout gridview for fragment=2 ie inside room_fragment*/
                    List<ItemObject> allItems = getAllDeviceItemObject();
                    MainDeviceButtonAdapter customAdapter = new MainDeviceButtonAdapter(getContext(), allItems);
                    listView.setDescendantFocusability(ViewGroup.FOCUS_AFTER_DESCENDANTS);
                    listView.setAdapter(customAdapter);
                    return view;
                }

                case 3: {/*Room FRAGMENT VIEW*/


                    View view = inflater.inflate(R.layout.case_room_fragment, container, false);
                    GridView gridview = (GridView) view.findViewById(R.id.gridView);
                    List<ItemObject> allItems = getAllRoomItemObject();
                    MainRoomButtonAdapter customAdapter = new MainRoomButtonAdapter(getContext(), allItems);
                    gridview.setDescendantFocusability(ViewGroup.FOCUS_AFTER_DESCENDANTS);

                    gridview.setAdapter(customAdapter);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        gridview.setNestedScrollingEnabled(true);
                    }

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
                    return "Device View";
                case 2:
                    return "Room View";
            }
            return null;
        }
    }


}
