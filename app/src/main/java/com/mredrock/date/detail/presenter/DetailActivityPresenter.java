package com.mredrock.date.detail.presenter;

import android.os.Bundle;
import android.view.Menu;

import com.mredrock.date.R;
import com.mredrock.date.app.BaseActivityPresenter;
import com.mredrock.date.config.C;
import com.mredrock.date.detail.view.DetailActivityVu;
import com.mredrock.date.model.DetailMode;
import com.mredrock.date.widget.DetailArrayAdapter;

public class DetailActivityPresenter extends BaseActivityPresenter<DetailActivityVu> {
    private DetailArrayAdapter mAdapter;
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
        mAdapter = new DetailArrayAdapter(this);
        vu.setLoadDetail(getIntent().getStringExtra(C.DETAIL_TAG));
    }
}
