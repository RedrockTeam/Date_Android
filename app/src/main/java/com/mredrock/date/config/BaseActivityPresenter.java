package com.mredrock.date.config;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.mredrock.date.R;

/**
 * Created by zhuchenxi on 15/4/21.
 */
public abstract class BaseActivityPresenter<V extends IVu> extends ActionBarActivity implements IPresenter<V> {
    protected Toolbar toolbar;
    protected V vu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            vu = getVuClass().newInstance();
            vu.init(getLayoutInflater(), null);
            setContentView(vu.getView());
            onBindVu();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    protected <E extends View> E $(int id){
        return (E)findViewById(id);
    }

    protected void setToolBar(boolean backAble){
        toolbar = $(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(backAble);
    }

    @Override
    protected final void onDestroy() {
        onDestroyVu();
        vu = null;
        super.onDestroy();
    }

    public void onBindVu(){};

    public void onDestroyVu(){};


}
