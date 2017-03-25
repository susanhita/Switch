package com.habijabi.root.aswitch;

import android.net.Uri;
import android.os.Build;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.List;

public class CreateSetup extends AppCompatActivity {


    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS);
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.create_setup);/*BACKGROUND OF MAINPAGE CONTAINING ROOMVIEW,FAVEVIEW AND DEVICE VIEW]*/
        mSectionsPagerAdapter = new CreateSetup.SectionsPagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.container);/*PLACE CONTATING THE 3 VIEWS ROOM,DEVICE AND FAVE*/
        mViewPager.setAdapter(mSectionsPagerAdapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);/*THE SLIDABLE TABS*/
        tabLayout.setupWithViewPager(mViewPager);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_inout);

        ImageView img=(ImageView) findViewById(R.id.swipe);
        img.startAnimation(animation);
    }



    public static class PlaceholderFragment extends Fragment {

        private static final String ARG_SECTION_NUMBER = "section_number";/*1 2 OR 3 CORSPONDING TO FAVE ROOM AND DEVICE*/

        public static PlaceholderFragment newInstance(int sectionNumber) {/*RETURNS THE CORRESPONDING FRAGMENT ROOM,DEVICE OR FAVE*/
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {/*INFLATING EACH FRAGMENT*/
            switch (getArguments().getInt(ARG_SECTION_NUMBER)) {


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
            // Show 7 total pages.
            return 7;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 1:{

                }
                case 3:{

                }
                case 5:{

                }
                case 7:{

                }

            }
            return null;
        }
    }


}





