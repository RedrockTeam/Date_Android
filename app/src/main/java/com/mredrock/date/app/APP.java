package com.mredrock.date.app;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.mredrock.date.util.Utils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Mr.Jude on 2015/4/22.
 */
public class APP extends Application {
    private static APP instance;
    public APP getInstence(){
        return instance;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        Utils.initialize(this,"DateTag","0");
        Fresco.initialize(this);
    }
}
