package com.ant.jobgod.imagetool.imageprovider.net.searchers;


import com.ant.jobgod.imagetool.imageprovider.net.NetImage;
import com.ant.jobgod.imagetool.imageprovider.net.SearcherConstructor;
import com.google.gson.Gson;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;

/**
 * Created by Mr.Jude on 2015/2/23.
 */
public class SosoSearcher implements SearcherConstructor {
    @Override
    public HashMap<String, String> getHeader() {
        return null;
    }

    @Override
    public String getUrl(String word, int page) {
        try {
            word = URLEncoder.encode(word, "gbk");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "http://pic.sogou.com/pics?query="+word+"&start="+page*48+"&reqType=ajax&reqFrom=result";
    }

    @Override
    public NetImage[] getImageList(String response) {
        try{
        SosoImage.WallImageResult result = new Gson().fromJson(response, SosoImage.WallImageResult.class);
        SosoImage[] imgs = result.getData();
        return imgs;
    }catch (Exception e){
        return new SosoImage[]{};
    }
    }

    private class SosoImage extends NetImage {
        private String thumbUrl;
        private String pic_url_noredirect;
        private int thumb_width;
        private int thumb_height;


        @Override
        public String getThumbImg() {
            return thumbUrl;
        }

        @Override
        public String getLargeImg() {
            return pic_url_noredirect;
        }

        @Override
        public int getWidth() {
            return thumb_width;
        }

        @Override
        public int getHeight() {
            return thumb_height;
        }

        public class WallImageResult {
            private SosoImage[] items;

            public SosoImage[] getData() {
                return items;
            }

            public void setData(SosoImage[] data) {
                this.items = data;
            }

        }
    }
}
