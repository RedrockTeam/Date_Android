package com.mredrock.date.home.view;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.view.SimpleDraweeView;
import com.mredrock.date.app.IVu;

/**
 * Created by Mr.Jude on 2015/4/22.
 */
public class BannerPagerAdapterVu implements IVu {
    SimpleDraweeView view;

    @Override
    public void init(LayoutInflater inflater, ViewGroup container) {
        view = new SimpleDraweeView(inflater.getContext());
        view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
    }

    @Override
    public View getView() {
        return view;
    }

    public void setImage(String url){
        view.setImageURI(Uri.parse(url));
    }

    public void setOnClickListener(View.OnClickListener listener){
        view.setOnClickListener(listener);
    }
}
