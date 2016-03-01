package com.test.michael.nutritionproject;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.test.michael.nutritionproject.ui.NavigationDrawerActivity;
import com.test.michael.nutritionproject.utils.UIUtils;

/**
 * User: Michael(michael.hms@outlook.com)
 * Date: 2016-02-29
 * Time: 10:04
 * Description:基类
 */
public abstract class BaseAppCompatActivity extends AppCompatActivity {
    public Toolbar mActionBarToolBar;
    protected abstract int getContentViewLayoutId();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewLayoutId());
        //mActionBarToolBar = (Toolbar)findViewById(R.id.actionbarToolbar);
        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.KITKAT) {
            int statusBarHeight = UIUtils.getStatusBarHeight(this);
            mActionBarToolBar.setPadding(0,statusBarHeight,0,0);
        }
        setUpActionBar();
    }
    private void setUpActionBar(){
        setSupportActionBar(mActionBarToolBar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar !=null  && ( this instanceof NavigationDrawerActivity)){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}