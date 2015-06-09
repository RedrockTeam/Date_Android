package com.mredrock.date.setting.view;

import android.widget.TextView;

import com.mredrock.date.R;
import com.mredrock.date.app.BaseActivityVu;
import com.mredrock.date.util.Utils;

/**
 * Created by zhuchenxi on 15/6/9.
 */
public class AboutActivityVu extends BaseActivityVu {

    @Override
    protected void onCreate() {
        setView(R.layout.activity_about);
        ((TextView)$(R.id.version)).setText("约 Android v"+Utils.getAppVersionName());
    }
}
