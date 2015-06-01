package com.mredrock.date.detail.presenter;

import android.os.Bundle;
import android.view.Menu;

import com.mredrock.date.R;
import com.mredrock.date.app.BaseActivityPresenter;
import com.mredrock.date.config.C;
import com.mredrock.date.detail.view.DetailActivityVu;
import com.mredrock.date.model.DetailMode;

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
    public void onBindVu() {
        super.onBindVu();
        vu.setView(getIntent().getStringExtra(C.DETAIL_TAG));
    }
}
