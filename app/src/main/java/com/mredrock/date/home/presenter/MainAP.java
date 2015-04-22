package com.mredrock.date.home.presenter;

import android.os.Bundle;

import com.mredrock.date.config.BaseAP;
import com.mredrock.date.home.view.MainAV;

/**
 * Created by zhuchenxi on 15/4/21.
 */
public class MainAP extends BaseAP<MainAV> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        vu.SayHello();
    }


    @Override
    public Class<MainAV> getVuClass() {
        return MainAV.class;
    }
}
