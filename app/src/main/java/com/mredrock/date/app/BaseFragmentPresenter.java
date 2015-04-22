package com.mredrock.date.app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Mr.Jude on 2015/4/22.
 */
public abstract class BaseFragmentPresenter<V extends IVu> extends Fragment implements IPresenter<V>{
    protected V vu;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        try {
            vu = getVuClass().newInstance();
            vu.init(inflater, container);
            onBindVu();
        } catch (java.lang.InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return vu.getView();
    }

    @Override
    public final void onDestroyView() {
        onDestroyVu();
        vu = null;
        super.onDestroyView();
    }

}
