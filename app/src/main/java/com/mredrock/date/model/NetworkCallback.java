package com.mredrock.date.model;

import java.util.List;

/**
 * Created by Lecion on 5/6/15.
 */
public interface NetworkCallback<T> {
    void onPre();

    void onSuccess(List<T> data);

    void onFailure(String info);
}
