package com.mredrock.date.model;

import android.util.Log;

import com.mredrock.date.app.TokenParams;
import com.mredrock.date.config.Api;

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

    @Override
    protected String module() {
        return Api.Module.LETTER;
    }

    @Override
    protected int page() {
        return 10;
    }


}
