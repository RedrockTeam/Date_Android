package com.mredrock.date.detail.presenter;

import android.os.Bundle;
import android.view.Menu;

import com.mredrock.date.R;
import com.mredrock.date.app.BaseActivityPresenter;
import com.mredrock.date.detail.view.DetailActivityVu;

public class DetailActivityPresenter extends BaseActivityPresenter<DetailActivityVu> {
    @Override
    public Class<DetailActivityVu> getVuClass() {
        return DetailActivityVu.class;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }
}
