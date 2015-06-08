package com.mredrock.date.model;

import com.android.http.RequestManager;
import com.android.http.RequestMap;
import com.mredrock.date.config.Api;

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


    protected void post (final String method, RequestMap map, final RequestManager.RequestListener callback) {
        RequestManager.getInstance().post(url(method), map, callback);
    }

    protected abstract String module();

    protected abstract int page();
}
