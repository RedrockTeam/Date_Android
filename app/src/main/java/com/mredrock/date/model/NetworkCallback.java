package com.mredrock.date.model;

import com.android.http.RequestManager;
import com.google.gson.Gson;
import com.mredrock.date.app.APP;
import com.mredrock.date.config.Api;
import com.mredrock.date.util.Utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.ParameterizedType;

/**
 * Created by Lecion on 5/6/15.
 */
public abstract class NetworkCallback<T> implements RequestManager.RequestListener{

    @Override
    public void onRequest() {
        pre();
    }

    @Override
    public void onError(String s) {
        error(Api.Code.SERVER_ERROR, "服务器端错误");
    }

    @Override
    public void onSuccess(String s) {
        try {
            JSONObject jsonObject = new JSONObject(s);
            int status = jsonObject.getInt(Api.Key.STATUS);
            if (status == Api.Code.OK) {
                if (jsonObject.has(Api.Key.DATA)) {
                    JSONArray dataArr = jsonObject.getJSONArray(Api.Key.DATA);
                    T data = new Gson().fromJson(dataArr.toString(), ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
                    success(data);
                } else {
                    success((T) jsonObject.getString(Api.Key.INFO));
                }

            } else if(status == Api.Code.PERMISSION_DENIED){
                APP.getInstence().closeToLogin();
                Utils.Toast("请重新登陆");
            }else{
                error(status, jsonObject.getString(Api.Key.INFO));
            }

        } catch (JSONException e) {
            e.printStackTrace();
            error(Api.Code.SERVER_ERROR, "服务器端错误");
        }
    }

    protected abstract void pre();

    protected abstract void success(T data);

    protected abstract void error(int errCode, String info);
}
