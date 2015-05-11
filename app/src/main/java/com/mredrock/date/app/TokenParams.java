package com.mredrock.date.app;

import com.android.http.RequestMap;
import com.mredrock.date.config.Api;

import java.io.File;

/**
 * Created by zhuchenxi on 15/5/11.
 */
public class TokenParams extends RequestMap{
    public TokenParams() {
        super();
        addToken();
    }

    public TokenParams(String key, String value) {
        super(key, value);
        addToken();
    }

    @Override
    public void put(String key, File file) {
        super.put(key, file);
        addToken();
    }

    private void addToken(){
        put(Api.Key.TOKEN,"nasdfnldssdaf");
        put(Api.Key.UID,"1");
    }
}
