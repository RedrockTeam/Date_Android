package com.mredrock.date.home.presenter;

import android.os.Bundle;

import com.mredrock.date.R;
import com.mredrock.date.config.BaseActivity;

/**
 * Created by zhuchenxi on 15/4/21.
 */
public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setToolBar(false);
    }
}
