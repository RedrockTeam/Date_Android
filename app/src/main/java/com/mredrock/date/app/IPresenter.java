package com.mredrock.date.app;

/**
 * Created by Mr.Jude on 2015/4/21.
 */
public interface IPresenter<V> {
    public Class<V> getVuClass();

    public void onBindVu();

    public void onDestroyVu();
}
