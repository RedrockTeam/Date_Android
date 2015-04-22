package com.mredrock.date.home.view;

import android.content.res.Configuration;
import android.support.v4.view.PagerAdapter;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.jude.view.jpagerview.JPagerView;
import com.mredrock.date.R;
import com.mredrock.date.app.BaseActivityVu;
import com.mredrock.date.home.presenter.DrawerFragmentPresenter;
import com.mredrock.date.util.Utils;

/**
 * Created by Mr.Jude on 2015/4/21.
 */
public class MainActivityVu extends BaseActivityVu {
    private JPagerView jpvBanner;
    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate() {
        setContentView(R.layout.activity_main);
        jpvBanner = $(R.id.jpv_banner);
        drawerLayout = $(R.id.drawerLayout);
    }

    public void addDrawer(final ActionBarActivity act,DrawerFragmentPresenter presenter){
        mDrawerToggle = new ActionBarDrawerToggle(act, drawerLayout, getToolbar(), R.string.drawer_open, R.string.drawer_close){

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view)
            {
                act.invalidateOptionsMenu(); // creates call to
                // onPrepareOptionsMenu()
            }

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView)
            {

                act.invalidateOptionsMenu(); // creates call to
                // onPrepareOptionsMenu()
            }
        };
        drawerLayout.setDrawerListener(mDrawerToggle);
        drawerLayout.post(new Runnable() {
            @Override
            public void run() {
                mDrawerToggle.syncState();
            }
        });
        final View container = $(R.id.drawer);
        container.post(new Runnable() {
            @Override
            public void run() {
                Utils.resizeView(container, Utils.getScreenWidth() - Utils.dip2px(56), ViewGroup.LayoutParams.MATCH_PARENT);
            }
        });
        act.getSupportFragmentManager().beginTransaction().add(R.id.drawer,presenter,"drawer").commit();
    }

    public void setBannerAdapter(PagerAdapter adapter){
        jpvBanner.setAdapter(adapter);
    }

    public void sayHello(){
        Toast.makeText(getContext(),"Hello World",Toast.LENGTH_SHORT);
    }

    public boolean onDrawerToggleSelected(MenuItem item){
        if (mDrawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return false;
    }

    public void onPostCreate()
    {
        mDrawerToggle.syncState();
    }


    public void onConfigurationChanged(Configuration newConfig)
    {
        mDrawerToggle.onConfigurationChanged(newConfig);

    }
}
