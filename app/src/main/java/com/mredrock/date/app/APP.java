package com.mredrock.date.app;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.mredrock.date.util.Utils;

/**
 * Created by Mr.Jude on 2015/4/22.
 */
public class APP extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Utils.initialize(this,"DateTag","0");
        Fresco.initialize(this);
    }
}
