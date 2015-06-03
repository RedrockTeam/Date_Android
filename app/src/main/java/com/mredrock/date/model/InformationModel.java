package com.mredrock.date.model;


import com.android.http.RequestManager;
import com.android.http.RequestMap;
import com.mredrock.date.config.Api;
import com.mredrock.date.util.Utils;

/**
 * Created by Administrator on 2015/6/4.
 */
public class InformationModel {
    public void getInformation(){
        RequestMap params = new RequestMap();
        params.put("uid","1");
        params.put("token","nasdfnldssdaf");
        params.put("get_uid","1");
        RequestManager.getInstance().post(Api.Url.Information, params, new RequestManager.RequestListener() {
            @Override
            public void onRequest() {

            }

            @Override
            public void onSuccess(String s) {
                Utils.Toast(s);
            }

            @Override
            public void onError(String s) {

            }
        });
    }

}
