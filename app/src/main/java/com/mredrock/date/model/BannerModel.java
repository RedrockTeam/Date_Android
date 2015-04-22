package com.mredrock.date.model;

import com.mredrock.date.model.bean.Banner;

/**
 * Created by Mr.Jude on 2015/4/22.
 */
public class BannerModel {
    private Banner[] banners = {
            new Banner("http://imgsrc.baidu.com/forum/w%3D580/sign=804a6a5da9ec8a13141a57e8c7029157/e8abb7c27d1ed21bd9926057ad6eddc450da3fec.jpg",""),
            new Banner("http://imgsrc.baidu.com/forum/w%3D580/sign=dd0e8796b31bb0518f24b320067bda77/edb4b51ea8d3fd1f354d298e304e251f94ca5ff9.jpg",""),
            new Banner("http://imgsrc.baidu.com/forum/w%3D580/sign=c3cda9ccd11373f0f53f6f97940e4b8b/fbd1e31f3a292df5f2709da2bc315c6035a87390.jpg",""),
            new Banner("http://image.baidu.com/detail/newindex?col=%E5%A3%81%E7%BA%B8&tag=%E5%85%A8%E9%83%A8&tag3=&filter=&hasstock=&dresstype=&dressid=-1&req=&pn=10&pid=9423310821&aid=372237473&setid=-1&user_id=850006430&sort=0&width=1366&height=768&fr=&from=1",""),
    };

    public interface onBannerCallback{
        void callback(Banner[] banners);
    }

    public Banner[] getBannerList(){
        return banners;
    }

    public Banner getBanner(int position){
        return banners[position];
    }

    public int getBannerLenght(){
        return banners.length;
    }

    public void getBannerListFromServer(onBannerCallback callback){
        if (banners!=null)
            callback.callback(banners);
    }
}
