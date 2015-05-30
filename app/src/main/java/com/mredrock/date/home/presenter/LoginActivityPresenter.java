package com.mredrock.date.home.presenter;

import android.view.View;

import com.mredrock.date.app.BaseActivityPresenter;
import com.mredrock.date.home.view.LoginActivityVu;

/**
 * Created by Mr.Jude on 2015/5/29.
 */
public class LoginActivityPresenter extends BaseActivityPresenter<LoginActivityVu> {

    @Override
    public void onBindVu() {
        vu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public Class<LoginActivityVu> getVuClass() {
        return LoginActivityVu.class;
    }
}
