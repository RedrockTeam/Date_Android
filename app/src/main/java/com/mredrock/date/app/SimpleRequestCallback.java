package com.mredrock.date.app;

import com.alibaba.fastjson.JSON;
import com.android.http.RequestManager;
import com.mredrock.date.config.Api;
import com.mredrock.date.util.Utils;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by zhuchenxi on 15/5/11.
 */
public abstract class SimpleRequestCallback<T> implements RequestManager.RequestListener {
    private Class<T> clazz;
    public SimpleRequestCallback(Class<T> clazz){
        this.clazz = clazz;
    }



    @Override
    public void onRequest() {
    }

    @Override
    public void onSuccess(String s) {
        JSONObject jsonObject;
        try {
            jsonObject = new JSONObject(s);
            int status = jsonObject.getInt(Api.Key.STATUS);
            String info = jsonObject.getString(Api.Key.INFO);
            if (status == Api.Code.OK){
                T data = JSON.parseObject(jsonObject.getString(Api.Key.DATA), clazz);
                success(info,data);
            }else if (status == Api.Code.PERMISSION_DENIED){
                authorizationFailure();
            }else if (status == Api.Code.SERVER_ERROR){
                error("服务器错误");
            }else{
                error(info);
                Utils.Log("未知状态:"+status);
            }
        } catch (JSONException e) {
            error("数据解析错误");
        }
    }

    @Override
    public void onError(String s) {
        error("网络错误");
    }

    public abstract void success(String info , T data);
    public void authorizationFailure(){
        APP.getInstence().closeToLogin();
        Utils.Toast("请重新登陆");
    }
    public abstract void error(String errorInfo);

}
