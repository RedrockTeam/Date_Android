package com.mredrock.date.home.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.mredrock.date.R;
import com.mredrock.date.home.presenter.IMainAV;

/**
 * Created by Mr.Jude on 2015/4/21.
 */
public class MainAV implements IMainAV {
    private View root;

    @Override
    public void init(LayoutInflater inflater, ViewGroup container) {
        root = inflater.inflate(R.layout.activity_main,null);
    }

    @Override
    public View getView() {
        return root;
    }

    @Override
    public void sayHello() {
        Toast.makeText(root.getContext(),"Hello World",Toast.LENGTH_SHORT).show();
    }
}
