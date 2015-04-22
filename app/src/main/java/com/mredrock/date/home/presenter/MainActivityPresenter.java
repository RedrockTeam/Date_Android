package com.mredrock.date.home.presenter;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;

import com.mredrock.date.app.BaseActivityPresenter;
import com.mredrock.date.home.view.MainActivityVu;

/**
 * Created by zhuchenxi on 15/4/21.
 */
public class MainActivityPresenter extends BaseActivityPresenter<MainActivityVu> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        vu.sayHello();
        vu.setBannerAdapter(new BannerPagerAdapterPresenter());
        vu.addDrawer(this, new DrawerFragmentPresenter());
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
