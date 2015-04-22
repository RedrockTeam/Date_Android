package com.mredrock.date.model;

import com.mredrock.date.model.bean.Banner;
import com.mredrock.date.widget.OnDataCallback;

/**
 * Created by Mr.Jude on 2015/4/22.
 */
public class BannerModel {
    private Banner[] banners = {
            new Banner("http://i1.hdslb.com/promote/8ff6cd36c2ba313bf887ed9f2a4f2d6e.jpg",""),
            new Banner("http://i1.hdslb.com/u_user/fd74d9f013a6696214adc19ddee5c475.jpg",""),
            new Banner("http://i0.hdslb.com/promote/33061005a8517b7d499b6fe9fa936318.jpg",""),
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
