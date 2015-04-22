package com.mredrock.date.home;

import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.view.SimpleDraweeView;
import com.jude.view.jpagerview.JStatePagerAdapter;
import com.mredrock.date.model.BannerModel;
import com.mredrock.date.model.bean.Banner;

/**
 * Created by Mr.Jude on 2015/4/22.
 */
public class BannerPagerAdapter extends JStatePagerAdapter{
    BannerModel model = new BannerModel();

    public BannerPagerAdapter(){
        model.getBannerListFromServer(new BannerModel.onBannerCallback() {
            @Override
            public void callback(Banner[] banners) {
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public View getView(ViewGroup container, final int position) {
        SimpleDraweeView view = new SimpleDraweeView(container.getContext());
        view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        view.setImageURI(Uri.parse(model.getBanner(position).getImg()));
        return view;
    }

    @Override
    public int getCount() {
        return model.getBannerLenght();
    }


}
