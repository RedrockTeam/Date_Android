package com.mredrock.date.home.presenter;

import com.mredrock.date.app.BaseFragmentPresenter;
import com.mredrock.date.home.view.DrawerFragmentVu;

/**
 * Created by Mr.Jude on 2015/4/22.
 */
public class DrawerFragmentPresenter extends BaseFragmentPresenter<DrawerFragmentVu> {


    @Override
    public Class<DrawerFragmentVu> getVuClass() {
        return DrawerFragmentVu.class;
    }

    @Override
    public void onBindVu() {
    }

    @Override
    public void onDestroyVu() {
    }
}
