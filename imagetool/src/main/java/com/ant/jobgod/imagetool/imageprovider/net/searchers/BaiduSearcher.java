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
public class BaiduSearcher implements SearcherConstructor {
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
        return "http://image.baidu.com/i?tn=resultjson_com&word="+word+"&rn=20&pn="+(page*20);
    }

    @Override
    public NetImage[] getImageList(String response) {
        try {
            BaiduImage.WallImageResult result = new Gson().fromJson(response, BaiduImage.WallImageResult.class);
            BaiduImage[] imgs = result.getData();
            return imgs;
        }catch (Exception e){
            return new BaiduImage[]{};
        }
    }

    private class BaiduImage extends NetImage {
        private String thumbURL;
        private int width;
        private int height;


        @Override
        public String getThumbImg() {
            return thumbURL;
        }

        @Override
        public String getLargeImg() {
            return thumbURL;
        }

        @Override
        public int getWidth() {
            return width;
        }

        @Override
        public int getHeight() {
            return height;
        }

        public class WallImageResult {
            private BaiduImage[] data;

            public BaiduImage[] getData() {
                return data;
            }

            public void setData(BaiduImage[] data) {
                this.data = data;
            }

        }
    }
}
