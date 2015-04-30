package com.mredrock.date.home.presenter;

import com.mredrock.date.app.BaseActivityPresenter;
import com.mredrock.date.home.view.EditActivityVu;

/**
 * Created by zhuchenxi on 15/4/30.
 */
public class EditActivityPresent extends BaseActivityPresenter<EditActivityVu> {
    @Override
    public Class<EditActivityVu> getVuClass() {
        return EditActivityVu.class;
    }
}
