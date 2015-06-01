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
        put(Api.Key.TOKEN,"f3863ca2ec2846496a5a5e55210e1104");
        put(Api.Key.UID,"7");
    }
}
