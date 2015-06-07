package com.mredrock.date.home.presenter;

import android.content.Intent;
import android.view.View;

import com.afollestad.materialdialogs.MaterialDialog;
import com.alibaba.fastjson.JSON;
import com.android.http.RequestManager;
import com.android.http.RequestMap;
import com.mredrock.date.app.APP;
import com.mredrock.date.app.BaseActivityPresenter;
import com.mredrock.date.app.SimpleRequestCallback;
import com.mredrock.date.config.Api;
import com.mredrock.date.home.view.LoginActivityVu;
import com.mredrock.date.util.Utils;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Mr.Jude on 2015/5/29.
 */
public class LoginActivityPresenter extends BaseActivityPresenter<LoginActivityVu> {

    @Override
    public void onBindVu() {
        if(!APP.getInstence().getToken().isEmpty()){
            startActivity(new Intent(LoginActivityPresenter.this, MainActivityPresenter.class));
            finish();
        }
        vu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final MaterialDialog dialog = new MaterialDialog.Builder(LoginActivityPresenter.this)
                        .title("登陆中")
                        .content("请稍后")
                        .progress(true, 100)
                        .cancelable(false)
                        .show();

                RequestMap params = new RequestMap();
                params.put("username",vu.tvNumber.getText().toString());
                params.put("password",vu.tvPassword.getText().toString());
                RequestManager.getInstance().post(Api.Url.Login, params, new RequestManager.RequestListener() {
                    @Override
                    public void onRequest() {

                    }

                    @Override
                    public void onSuccess(String s) {
                        dialog.dismiss();
                        JSONObject jsonObject;
                        try {
                            jsonObject = new JSONObject(s);
                            int status = jsonObject.getInt(Api.Key.STATUS);
                            String info = jsonObject.getString(Api.Key.INFO);
                            if (status!=200){
                                Utils.Toast(info);
                            }else{
                                APP.getInstence().setToken(jsonObject.getString(Api.Key.TOKEN));
                                APP.getInstence().setUID(jsonObject.getString(Api.Key.UID));
                                startActivity(new Intent(LoginActivityPresenter.this, MainActivityPresenter.class));
                                finish();
                            }

                        } catch (JSONException e) {

                        }
                    }

                    @Override
                    public void onError(String s) {
                        dialog.dismiss();
                        Utils.Toast("网络错误");
                    }
                });
            }
        });
    }

    @Override
    public Class<LoginActivityVu> getVuClass() {
        return LoginActivityVu.class;
    }


}
