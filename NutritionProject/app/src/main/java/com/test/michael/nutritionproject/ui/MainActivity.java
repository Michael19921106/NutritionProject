package com.test.michael.nutritionproject.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.test.michael.nutritionproject.R;
import com.test.michael.nutritionproject.ui.material.MaterialFragment;
import com.test.michael.nutritionproject.ui.news.NewsFragment;
import com.test.michael.nutritionproject.ui.setting.SettingActivity;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Fragment currentFragment;

    private Fragment newsFragment;
    private Fragment materialFragment;

    private final String TAB_NEWS = "news";
    private final String TAB_MATERIAL = "material";
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        if (savedInstanceState !=null){
            FragmentManager fragmentManager = getSupportFragmentManager();
            newsFragment = fragmentManager.findFragmentByTag(TAB_NEWS);
            materialFragment = fragmentManager.findFragmentByTag(TAB_MATERIAL);
        }

    }

    public void initData(){

       toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

//    private void setSelection(int position) {
//
//        FragmentManager fm = getSupportFragmentManager();
//        FragmentTransaction ft = fm.beginTransaction();
//        hideAllFragments(ft);
//
//        switch (position) {
//            case R.id.radio_info:
//                if (infoFragment == null) {
//                    infoFragment = TabInfoFragment.getInstance();
//                    ft.add(R.id.content, infoFragment, TAG_INFO);
//                } else {
//                    ft.show(infoFragment);
//                }
//                break;
//            case R.id.radio_data:
//                if (dataFragment == null) {
//                    dataFragment = TabDataFragment.getInstance();
//                    ft.add(R.id.content, dataFragment, TAG_DATA);
//                } else {
//                    ft.show(dataFragment);
//                }
//                break;
//            case R.id.radio_mine:
//                if (mineFragment == null) {
//                    mineFragment = TabMineFragment.getInstance();
//                    ft.add(R.id.content, mineFragment, TAG_MINE);
//                } else {
//                    ft.show(mineFragment);
//                }
//                break;
//        }
//        ft.commit();
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        hideAllFragments(ft);

        if (id == R.id.nav_news) {
            // Handle the camera action
            toolbar.setTitle("资讯");
            if (newsFragment == null) {
                newsFragment = NewsFragment.getInstance();
                    ft.add(R.id.container, newsFragment, TAB_NEWS);
                } else {
                    ft.show(newsFragment);
                }

        } else if (id == R.id.nav_material) {
            // Handle the camera action
            toolbar.setTitle("资料");
            if (materialFragment == null) {
                materialFragment = MaterialFragment.getInstance();
                ft.add(R.id.container, materialFragment, TAB_MATERIAL);
            } else {
                ft.show(materialFragment);
            }

        } else if (id == R.id.nav_collect){

        } else if (id == R.id.nav_download){

        }else if (id == R.id.nav_day_or_night) {

        } else if (id == R.id.nav_setting) {
            Intent toSetting = new Intent(MainActivity.this, SettingActivity.class);
            toSetting.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(toSetting);

        } else if (id == R.id.nav_about) {

        }
        ft.commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    private void hideAllFragments(FragmentTransaction ft) {

        if (newsFragment != null) {
            ft.hide(newsFragment);
        }

        if (materialFragment != null) {
            ft.hide(materialFragment);
        }
    }

}
