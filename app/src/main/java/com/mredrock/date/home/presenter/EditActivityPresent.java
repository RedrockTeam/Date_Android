package com.mredrock.date.home.presenter;

import android.view.Menu;
import android.view.MenuInflater;

import com.mredrock.date.R;
import com.mredrock.date.app.BaseActivityPresenter;
import com.mredrock.date.home.view.EditActivityVu;

/**
 * Created by zhuchenxi on 15/4/30.
 */
public class EditActivityPresent extends BaseActivityPresenter<EditActivityVu> {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_edit,menu);
        return true;
    }

    @Override
    public Class<EditActivityVu> getVuClass() {
        return EditActivityVu.class;
    }
}
