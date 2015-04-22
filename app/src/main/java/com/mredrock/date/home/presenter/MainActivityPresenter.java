package com.mredrock.date.home.presenter;

import android.os.Bundle;

import com.mredrock.date.config.BaseActivityPresenter;
import com.mredrock.date.home.view.MainActivityVu;

/**
 * Created by zhuchenxi on 15/4/21.
 */
public class MainActivityPresenter extends BaseActivityPresenter<MainActivityVu> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        vu.SayHello();
    }


    @Override
    public Class<MainActivityVu> getVuClass() {
        return MainActivityVu.class;
    }
}
