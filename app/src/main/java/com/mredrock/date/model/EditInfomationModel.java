package com.mredrock.date.model;

import com.android.http.RequestManager;
import com.mredrock.date.app.ResultRequestCallback;
import com.mredrock.date.app.TokenParams;
import com.mredrock.date.config.Api;
import com.mredrock.date.util.Utils;

/**
 * Created by Administrator on 2015/6/4.
 */
public class EditInfomationModel {
    public static void edit(String nickName,String gender,String tel,String qq,String weixin, final EditCallback callback){
        TokenParams params = new TokenParams();
        params.put("nickname",nickName);
        params.put("gender",gender);
        params.put("telephone",tel);
        params.put("qq",qq);
        params.put("weixin",weixin);
        RequestManager.getInstance().post(Api.Url.EditInformation, params, new ResultRequestCallback() {
            @Override
            public void success(String info) {
                callback.onSuccess(info);
            }

            @Override
            public void error(String errorInfo) {
                callback.onError(errorInfo);
            }
        });
    }
    public interface EditCallback{
       public void onSuccess(String info);
        public void onError(String errorInfo);
    }
}
