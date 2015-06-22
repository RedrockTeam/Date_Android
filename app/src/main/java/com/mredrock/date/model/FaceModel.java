package com.mredrock.date.model;

import android.util.Log;

import com.android.http.RequestManager;
import com.mredrock.date.app.ResultRequestCallback;
import com.mredrock.date.app.TokenParams;
import com.mredrock.date.config.Api;
import com.mredrock.date.util.Utils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;

/**
 * Created by Administrator on 2015/6/21.
 */
public class FaceModel {
    public static void  upload(String finalImageFile, final UploadFaceCallback callback){
        TokenParams params = new TokenParams();
        params.put("photo",new File(finalImageFile));
        RequestManager.getInstance().post(Api.Url.UploadFace, params, new RequestManager.RequestListener() {
            @Override
            public void onRequest() {

            }

            @Override
            public void onSuccess(String info) {
                Log.i("response",info);

                JSONObject jsonObject;
                try {
                    jsonObject=new JSONObject(info);
                    int status = jsonObject.getInt(Api.Key.STATUS);
                    String infos = jsonObject.getString(Api.Key.INFO);
                    if(status==200){
                        String  path = jsonObject.getString("path");
                        callback.onSuccess(path);
                    }else{
                        callback.onError(infos);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    callback.onError(info);
                }
            }

            @Override
            public void onError(String s) {
                callback.onError(s);
            }
        });
    }
    public interface UploadFaceCallback{
        public void onSuccess(String info);
        public void onError(String info);
    }
}
