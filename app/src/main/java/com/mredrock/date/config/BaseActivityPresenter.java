package com.mredrock.date.config;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.mredrock.date.R;

/**
 * Created by zhuchenxi on 15/4/21.
 */
public class BaseActivityPresenter extends ActionBarActivity {
    protected Toolbar toolbar;
    protected <E extends View> E $(int id){
        return (E)findViewById(id);
    }

    protected void setToolBar(boolean backAble){
        toolbar = $(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(backAble);
    }

}
