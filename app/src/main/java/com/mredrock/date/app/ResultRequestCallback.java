package com.mredrock.date.app;

import com.android.http.RequestManager;
import com.mredrock.date.config.Api;
import com.mredrock.date.util.Utils;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Mr.Jude on 2015/5/25.
 */
public abstract class ResultRequestCallback implements RequestManager.RequestListener {
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
                success(info);
            }else if (status == Api.Code.PERMISSION_DENIED){
                authorizationFailure();
            }else if (status == Api.Code.SERVER_ERROR){
                error("服务器错误");
            }else{
                error(info);
                Utils.Log("未知状态:" + status);
            }
        } catch (JSONException e) {
            error("数据解析错误");
        }
    }

    @Override
    public void onError(String s) {
        error(s);
    }

    public abstract void success(String info);
    public void authorizationFailure(){}
    public abstract void error(String errorInfo);
}
