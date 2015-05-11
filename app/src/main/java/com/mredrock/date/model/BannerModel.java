package com.mredrock.date.model;

import com.android.http.RequestManager;
import com.mredrock.date.app.SimpleRequestCallback;
import com.mredrock.date.app.TokenParams;
import com.mredrock.date.config.Api;
import com.mredrock.date.model.bean.Banner;
import com.mredrock.date.model.bean.Result;
import com.mredrock.date.widget.OnDataCallback;

/**
 * Created by Mr.Jude on 2015/4/22.
 */
public class BannerModel {
    private Banner[] banners;

    public Banner[] getBannerList(){
        return banners;
    }

    public Banner getBanner(int position){
        return banners[position];
    }

    public int getBannerLenght(){
        return banners.length;
    }

    public void getBannerListFromServer(final OnDataCallback<Banner> callback){
        RequestManager.getInstance().post(Api.Url.Banner, new TokenParams(), new SimpleRequestCallback<Banner[]>() {
            @Override
            public void success(String info, Banner[] data) {
                banners = data;
                if (banners!=null)
                    callback.callback(banners);
            }

            @Override
            public void error(String errorInfo) {

            }
        });

    }
}
