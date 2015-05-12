package com.mredrock.date.app;

import com.alibaba.fastjson.JSON;
import com.android.http.RequestManager;
import com.mredrock.date.config.Api;
import com.mredrock.date.util.Utils;

/**
 * Created by zhuchenxi on 15/5/11.
 */
public abstract class SimpleRequestCallback<T> implements RequestManager.RequestListener {
    private class Result{
        private int status;
        private String info;
        private T data;
    }

    @Override
    public void onRequest() {
    }

    @Override
    public void onSuccess(String s) {
        Result result = JSON.parseObject(s, Result.class);
        if (result.status == Api.Code.OK){
            success(result.info,result.data);
        }else if (result.status == Api.Code.PERMISSION_DENIED){
            authorizationFailure();
        }else if (result.status == Api.Code.SERVER_ERROR){
            error("服务器错误");
        }else{
            Utils.Log("未知状态:"+result.status);
        }
    }

    @Override
    public void onError(String s) {
        error("网络错误");
    }

    public abstract void success(String info , T data);
    public void authorizationFailure(){}
    public abstract void error(String errorInfo);

}
