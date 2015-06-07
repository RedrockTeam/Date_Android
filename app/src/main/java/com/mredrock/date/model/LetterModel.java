package com.mredrock.date.model;

import android.util.Log;

import com.android.http.RequestManager;
import com.mredrock.date.app.TokenParams;
import com.mredrock.date.config.Api;
import com.mredrock.date.widget.OnDataCallback;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Lecion on 5/5/15.
 */
public class LetterModel extends AbsModel{
    public static final String TAG = "LetterModel";

    public <T> void getLetters(int page, NetworkCallback<T> callback) {
        Log.d(TAG, "getLetters page " + page );
        TokenParams params = new TokenParams();
        params.put(Api.Key.PAGE, String.valueOf(page));
        post(Api.Method.GET_LETTER, params, callback);
    }

    /**
     * 更改约的状态
     * @param dateId
     * @param toId
     * @param action
     */
    public <T> void dateAction(int dateId, int toId, int action, NetworkCallback<T> callback) {
        TokenParams params = new TokenParams();
        params.put(Api.Key.Letter.TO_ID, String.valueOf(toId));
        params.put(Api.Key.Letter.DATA_ID, String.valueOf(dateId));
        params.put(Api.Key.Letter.ACTION, String.valueOf(action));
        post(Api.Method.DATE_ACTION, params, callback);
    }

    public void letterstatus(final OnDataCallback<Integer> callback){
        post(Api.Method.LATTER_STATUS, new TokenParams(), new RequestManager.RequestListener() {
            @Override
            public void onRequest() {

            }

            @Override
            public void onSuccess(String s) {
                JSONObject jsonObject = null;
                try {
                    jsonObject = new JSONObject(s);
                    int status = jsonObject.getInt(Api.Key.STATUS);
                    String info = jsonObject.getString(Api.Key.INFO);
                    if (status == Api.Code.OK){
                        callback.callback(jsonObject.getInt(Api.Key.LETTER));
                    }else{
                        callback.error(info);
                    }
                } catch (JSONException e) {
                    callback.error("解析错误");
                }

            }

            @Override
            public void onError(String s) {
                callback.error("网络错误");
            }
        });
    }

    @Override
    protected String module() {
        return Api.Module.LETTER;
    }

    @Override
    protected int page() {
        return 10;
    }


}
