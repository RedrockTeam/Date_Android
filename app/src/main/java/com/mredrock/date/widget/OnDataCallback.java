package com.mredrock.date.widget;

/**
 * Created by zhuchenxi on 15/4/22.
 */
public interface OnDataCallback<T> {
    void callback(T... list);
    void error(String info);
}
