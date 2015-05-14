package com.mredrock.date.model;

import android.util.Log;

import com.mredrock.date.app.TokenParams;
import com.mredrock.date.config.Api;
import com.umeng.message.proguard.T;

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
    public void dateAction(int dateId, int toId, int action, NetworkCallback<T> callback) {
        TokenParams params = new TokenParams();
        params.put(Api.Key.Letter.TO_ID, String.valueOf(toId));
        params.put(Api.Key.Letter.DATA_ID, String.valueOf(dateId));
        params.put(Api.Key.Letter.ACTION, String.valueOf(action));
        post(Api.Method.DATE_ACTION, params, callback);
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
