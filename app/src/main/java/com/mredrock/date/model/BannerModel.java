package com.mredrock.date.model;

import com.mredrock.date.model.bean.Banner;
import com.mredrock.date.widget.OnDataCallback;

/**
 * Created by Mr.Jude on 2015/4/22.
 */
public class BannerModel {
    private Banner[] banners = {
            new Banner("http://i2.hdslb.com/u_user/f234ff0f3e1c0e15d98a788a42e25bdf.jpg",""),
            new Banner("http://i1.hdslb.com/u_user/033f010d2be727e0bf59ab6c739b53b5.jpg",""),
            new Banner("http://i0.hdslb.com/u_user/725b729fb00b3545c404ee6e619a6045.jpg",""),
            new Banner("http://i0.hdslb.com/promote/d5fd393d56d42dce351399fa599068e8.jpg",""),
            new Banner("http://i1.hdslb.com/promote/5c617e96261a509786b4e941b88ffc1f.jpg",""),
    };

    public Banner[] getBannerList(){
        return banners;
    }

    public Banner getBanner(int position){
        return banners[position];
    }

    public int getBannerLenght(){
        return banners.length;
    }

    public void getBannerListFromServer(OnDataCallback<Banner> callback){
        if (banners!=null)
            callback.callback(banners);
    }
}
