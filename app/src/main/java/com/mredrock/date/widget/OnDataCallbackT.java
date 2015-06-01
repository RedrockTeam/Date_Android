package com.mredrock.date.widget;

public interface OnDataCallbackT<T> {
    void callback(T list);
    void error(String info);
}
