package com.mredrock.date.home.presenter;

import android.os.Bundle;

import com.mredrock.date.config.BaseActivityPresenter;
import com.mredrock.date.home.view.MainAV;

/**
 * Created by zhuchenxi on 15/4/21.
 */
public class MainAP extends BaseActivityPresenter<IMainAV> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        vu.sayHello();
    }


    @Override
    public Class<MainAV> getVuClass() {
        return MainAV.class;
    }
}
