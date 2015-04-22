package com.mredrock.date.home.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mredrock.date.R;
import com.mredrock.date.app.IVu;

/**
 * Created by Mr.Jude on 2015/4/22.
 */
public class DrawerFragmentVu implements IVu {
    private View view;

    @Override
    public void init(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.fragment_drawer,container,false);
    }

    @Override
    public View getView() {
        return view;
    }
}
