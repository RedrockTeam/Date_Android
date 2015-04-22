package com.mredrock.date.config;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

/**
 * Created by zhuchenxi on 15/4/21.
 */
public abstract class BaseActivityPresenter<V extends IVu> extends ActionBarActivity implements IPresenter<V> {

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

    @Override
    protected final void onDestroy() {
        onDestroyVu();
        vu = null;
        super.onDestroy();
    }

    public void onBindVu(){};

    public void onDestroyVu(){};


}
