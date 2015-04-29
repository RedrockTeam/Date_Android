package com.mredrock.date.home.presenter;

import com.mredrock.date.app.BaseActivityPresenter;
import com.mredrock.date.home.view.RecordActivityVu;

/**
 * Created by Mr.Jude on 2015/4/29.
 */
public class RecordActivityPresenter extends BaseActivityPresenter<RecordActivityVu> {

    @Override
    public Class<RecordActivityVu> getVuClass() {
        return RecordActivityVu.class;
    }
}
