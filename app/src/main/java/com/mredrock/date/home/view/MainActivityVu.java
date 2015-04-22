package com.mredrock.date.home.view;

import android.support.v4.view.PagerAdapter;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.jude.view.jpagerview.JPagerView;
import com.mredrock.date.R;
import com.mredrock.date.app.BaseActivityVu;

/**
 * Created by Mr.Jude on 2015/4/21.
 */
public class MainActivityVu extends BaseActivityVu {
    private JPagerView vpBanner;

    @Override
    protected void OnCreate() {
        setContentView(R.layout.activity_main);
        vpBanner = $(R.id.vp_banner);
    }

    @Override
    protected void onToolBarInit(ActionBarActivity act, Toolbar toolbar) {
        toolbar.setLogo(R.mipmap.ic_launcher);
        act.getSupportActionBar().setDisplayHomeAsUpEnabled(false);
    }

    public void setBannerAdapter(PagerAdapter adapter){
        vpBanner.setAdapter(adapter);
    }

    public void SayHello(){
        Toast.makeText(getContext(),"Hello World",Toast.LENGTH_SHORT);
    }
}
