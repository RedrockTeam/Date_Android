package com.mredrock.date.setting.presenter;

import android.content.Intent;
import android.view.View;

import com.mredrock.date.R;
import com.mredrock.date.app.APP;
import com.mredrock.date.app.BaseActivityPresenter;
import com.mredrock.date.setting.view.SettingActivityVu;

/**
 * Created by zhuchenxi on 15/6/9.
 */
public class SettingActivityPresenter extends BaseActivityPresenter<SettingActivityVu> {

    @Override
    public Class getVuClass() {
        return SettingActivityVu.class;
    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.feedback:
                startActivity(new Intent(this,FeedbackActivityPresenter.class));
                break;
            case R.id.logout:
                APP.getInstence().closeToLogin();
                break;
            case R.id.about:
                startActivity(new Intent(this,AboutActivityPresenter.class));
                break;
        }
    }
}
