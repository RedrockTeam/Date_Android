package com.mredrock.date.model;

import com.android.http.RequestManager;
import com.mredrock.date.app.ResultRequestCallback;
import com.mredrock.date.app.TokenParams;
import com.mredrock.date.config.Api;
import com.mredrock.date.model.bean.Information;
import com.mredrock.date.util.Utils;

/**
 * Created by Administrator on 2015/6/4.
 */
public class EditInfomationModel {
    public static void edit(Information information, final EditCallback callback){
        TokenParams params = new TokenParams();
        params.put("nickname",information.getNickname());
        params.put("signature",information.getSignature());
        params.put("gender",information.getGrade_id());
        params.put("grade",information.getGender());
        params.put("academy",information.getAcademy_id());
        params.put("telephone",information.getTelephone());
        params.put("qq",information.getQq());
        params.put("weixin",information.getWeixin());
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
