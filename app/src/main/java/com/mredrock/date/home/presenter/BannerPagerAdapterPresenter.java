package com.mredrock.date.home.presenter;

import android.view.View;
import android.view.ViewGroup;

import com.jude.view.jpagerview.JPagerAdapter;
import com.mredrock.date.config.IPresenter;
import com.mredrock.date.home.view.BannerPagerAdapterVu;

/**
 * Created by Mr.Jude on 2015/4/22.
 */
public class BannerPagerAdapterPresenter extends JPagerAdapter implements IPresenter<BannerPagerAdapterVu>{
    @Override
    public View getView(ViewGroup container, int position) {
        return null;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Class<BannerPagerAdapterVu> getVuClass() {
        return BannerPagerAdapterVu.class;
    }

    @Override
    public void onBindVu() {

    }

    @Override
    public void onDestroyVu() {

    }
}
