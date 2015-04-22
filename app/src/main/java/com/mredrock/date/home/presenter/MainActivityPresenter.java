package com.mredrock.date.home.presenter;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;

import com.mredrock.date.app.BaseActivityPresenter;
import com.mredrock.date.home.MainHeader;
import com.mredrock.date.home.view.MainActivityVu;
import com.mredrock.date.widget.AppointmentArrayAdapter;

/**
 * Created by zhuchenxi on 15/4/21.
 */
public class MainActivityPresenter extends BaseActivityPresenter<MainActivityVu> {
    private AppointmentArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        vu.addDrawer(this, new DrawerFragmentPresenter());
        adapter = new AppointmentArrayAdapter(this);
        adapter.addHeader(new MainHeader());
        vu.setRecyclerViewAdapter(adapter);
    }


    @Override
    public Class<MainActivityVu> getVuClass() {
        return MainActivityVu.class;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (vu.onDrawerToggleSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState)
    {
        super.onPostCreate(savedInstanceState);
        vu.onPostCreate();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig)
    {
        super.onConfigurationChanged(newConfig);
        vu.onConfigurationChanged(newConfig);
    }

}
