package com.mredrock.date.home.presenter;

import android.os.Bundle;

import com.mredrock.date.config.BaseActivityPresenter;

/**
 * Created by zhuchenxi on 15/4/21.
 */
public class MainActivityPresenter extends BaseActivityPresenter<com.mredrock.date.home.view.MainActivityPresenter> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        vu.SayHello();
    }


    @Override
    public Class<com.mredrock.date.home.view.MainActivityPresenter> getVuClass() {
        return com.mredrock.date.home.view.MainActivityPresenter.class;
    }
}
