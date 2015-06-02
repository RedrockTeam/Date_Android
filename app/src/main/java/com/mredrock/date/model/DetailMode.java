package com.mredrock.date.model;

import com.android.http.RequestManager;
import com.mredrock.date.app.SimpleRequestCallback;
import com.mredrock.date.app.TokenParams;
import com.mredrock.date.config.Api;
import com.mredrock.date.model.bean.Detail;
import com.mredrock.date.widget.OnDataCallback;

public class DetailMode {

    public void getDetailFromServer(String date_id, final OnDataCallback<Detail> callback){
        TokenParams params = new TokenParams();
        params.put(Api.Key.Detail.DATE_ID, date_id);
        RequestManager.getInstance().post(Api.Url.Detail, params, new SimpleRequestCallback<Detail>(Detail.class) {
            @Override
            public void success(String info, Detail data) {
                callback.callback(data);
            }

            @Override
            public void error(String errorInfo) {
                callback.error(errorInfo);
            }
        });
    }
}