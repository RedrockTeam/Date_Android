package com.mredrock.date.model;

import android.util.Log;

import com.android.http.RequestManager;
import com.android.http.RequestMap;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mredrock.date.config.Api;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by Lecion on 5/5/15.
 */
public abstract class AbsModel {

    public static final String TAG = "AbsModel";

    protected String url(String method) {
        StringBuilder sb = new StringBuilder();
        sb.append(Api.BASE_URL).append(Api.SEPERATOR).append(module()).append(Api.SEPERATOR).append(method);
        return sb.toString();
    }

    /**
     * 根据状态码返回信息
     * @param status
     * @return
     */
    protected String getResponseInfo(int status) {
        String msg = null;
        switch (status) {
            case Api.Code.OK:
                msg = "请求成功";
                break;

            case Api.Code.PERMISSION_DENIED:
                msg = "认证失败";
                break;

            default:
                msg = "未知错误";
        }
        return msg;
    }


    protected <T> void post (final String method, RequestMap map, final NetworkCallback<T> callback) {
        RequestManager.getInstance().post(url(method), map, new RequestManager.RequestListener() {
            @Override
            public void onRequest() {
                if (callback != null) {
                    callback.onPre();
                }
                Log.d(TAG, url(method));
            }

            @Override
            public void onSuccess(String s) {
                if (callback != null) {
                    try {
                        //json能成功解析
                        JSONObject jsonObject = new JSONObject(s);
                        int status = jsonObject.getInt(Api.Key.STATUS);
                        //状态码正常
                        Log.d(TAG, "status => " + status);
                        if (status == Api.Code.OK) {
                            JSONArray data = jsonObject.getJSONArray(Api.Key.DATA);
                            Gson gson = new Gson();
                            List<T> lists = gson.fromJson(data.toString(), new TypeToken<T>(){}.getType());
                            callback.onSuccess(lists);
                        } else {
                            //状态码不正常
                            callback.onFailure(getResponseInfo(status));
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                        //json解析失败，归为服务器端错误
                        callback.onFailure(getResponseInfo(Api.Code.SERVER_ERROR));
                    }
                }
            }

            @Override
            public void onError(String s) {
                if (callback != null) {
                    callback.onFailure(getResponseInfo(Api.Code.SERVER_ERROR));
                }
            }
        });
    }

    protected abstract String module();

    protected abstract int page();

}
