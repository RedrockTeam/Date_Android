package com.mredrock.date.home.presenter;

import android.view.View;

import com.mredrock.date.app.BaseFragmentPresenter;
import com.mredrock.date.home.view.DrawerFragmentVu;
import com.mredrock.date.model.PersonModel;

/**
 * Created by Mr.Jude on 2015/4/22.
 */
public class DrawerFragmentPresenter extends BaseFragmentPresenter<DrawerFragmentVu> implements View.OnClickListener{
    private PersonModel mPersonModel = new PersonModel();

    @Override
    public Class<DrawerFragmentVu> getVuClass() {
        return DrawerFragmentVu.class;
    }

    @Override
    public void onBindVu() {
        vu.setPerson(mPersonModel.getUserPersonBrief());
    }

    @Override
    public void onDestroyVu() {

    }


    @Override
    public void onClick(View v) {

    }
}
