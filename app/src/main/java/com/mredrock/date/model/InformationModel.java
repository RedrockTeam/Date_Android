package com.mredrock.date.model;


import com.android.http.RequestManager;
import com.android.http.RequestMap;
import com.mredrock.date.app.SimpleRequestCallback;
import com.mredrock.date.app.TokenParams;
import com.mredrock.date.config.Api;
import com.mredrock.date.model.bean.Information;
import com.mredrock.date.util.Utils;

/**
 * Created by Administrator on 2015/6/4.
 */
public class InformationModel {
    public static  void getInformation(String get_uid, final InforCallback callback){
        TokenParams params = new TokenParams();

        params.put("get_uid",get_uid);
        RequestManager.getInstance().post(Api.Url.Information, params, new SimpleRequestCallback<Information>(Information.class) {
            @Override
            public void success(String info, Information data) {
                callback.onSuccess(info,data);
            }

            @Override
            public void error(String errorInfo) {
                callback.onError(errorInfo);
            }
        });
    }
    public interface  InforCallback{
        public void onSuccess(String info,Information data);
        public void onError(String errorInfo);
    }
}
