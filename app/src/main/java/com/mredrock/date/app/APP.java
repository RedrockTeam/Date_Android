package com.mredrock.date.app;

import android.app.Application;
import android.content.Context;
import android.content.Intent;

import com.android.http.RequestManager;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.mredrock.date.home.presenter.LoginActivityPresenter;
import com.mredrock.date.util.JActivityManager;
import com.mredrock.date.util.Utils;

/**
 * Created by Mr.Jude on 2015/4/22.
 */
public class APP extends Application {
    private static APP instance;
    public static APP getInstence(){
        return instance;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        Utils.initialize(this,"DateTag","0");
        Fresco.initialize(this);
        RequestManager.getInstance().init(getApplicationContext());
        RequestManager.getInstance().setDebugMode(true, "NETDEBUG");
    }

    public String getToken(){
        return Utils.getPreference().getString("token","");
    }

    public void setToken(String token){
        Utils.getPreference().edit().putString("token", token).commit();
    }

    public void closeToLogin(){
        Utils.getPreference().edit().clear().commit();
        Context ctx = JActivityManager.getInstance().currentActivity();
        ctx.startActivity(new Intent(ctx, LoginActivityPresenter.class));
        JActivityManager.getInstance().popAllActivity();
    }

    public String getUID(){
        return Utils.getPreference().getString("uid","");
    }

    public void setUID(String token){
        Utils.getPreference().edit().putString("uid",token).commit();
    }
}
