package com.mredrock.date.setting.presenter;

import com.mredrock.date.app.BaseActivityPresenter;
import com.mredrock.date.app.BaseActivityVu;
import com.mredrock.date.setting.view.AboutActivityVu;

/**
 * Created by zhuchenxi on 15/6/9.
 */
public class AboutActivityPresenter extends BaseActivityPresenter<AboutActivityVu>{
    @Override
    public Class<AboutActivityVu> getVuClass() {
        return AboutActivityVu.class;
    }
}
