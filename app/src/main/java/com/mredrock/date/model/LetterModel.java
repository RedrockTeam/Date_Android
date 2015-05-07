package com.mredrock.date.model;

import android.util.Log;

import com.android.http.RequestMap;
import com.mredrock.date.config.Api;
import com.mredrock.date.model.bean.Letter;

/**
 * Created by Lecion on 5/5/15.
 */
public class LetterModel extends AbsModel{
    public static final String TAG = "LetterModel";

    public void getLetters(int page, NetworkCallback<Letter> callback) {
        Log.d(TAG, "getLetters");
        RequestMap map = new RequestMap();
        map.put(Api.Key.TOKEN, "token");
        map.put(Api.Key.PAGE, String.valueOf(page));
        map.put(Api.Key.UID, String.valueOf(1));
        post(Api.Method.GET_LETTER, map, callback, Letter[].class);
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
