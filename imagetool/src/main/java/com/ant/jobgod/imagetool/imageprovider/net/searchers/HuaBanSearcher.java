package com.ant.jobgod.imagetool.imageprovider.net.searchers;

import com.ant.jobgod.imagetool.imageprovider.net.NetImage;
import com.ant.jobgod.imagetool.imageprovider.net.SearcherConstructor;
import com.google.gson.Gson;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Created by Mr.Jude on 2015/6/5.
 * But Has BUG
 */
public class HuaBanSearcher  implements SearcherConstructor {
    @Override
    public HashMap<String, String> getHeader() {
        HashMap<String,String> map = new HashMap<>();
        map.put("X-Request","JSON");
        map.put("X-Requested-With","XMLHttpRequest");
        return map;
    }

    @Override
    public String getUrl(String word, int page) {
        return "http://huaban.com/search/?q="+word+"&iajdeopd=&page="+page+"&per_page=20&wfl=1";
    }

    @Override
    public NetImage[] getImageList(String response) {
        HuaBnaResult result = new Gson().fromJson(response,HuaBnaResult.class);
        HuaBanImage[] imgs = new HuaBanImage[result.pins.length];
        for (int i = 0 ; i < imgs.length ; i++){
            imgs[i] = new HuaBanImage(result.pins[i].file.key,result.pins[i].file.width,result.pins[i].file.height);
        }
        return imgs;
    }
    class HuaBnaResult{
        pins[] pins;
         class pins{
            file file;
             class file{
                String key;
                 int width;
                 int height;
            }
         }
    }

    private class HuaBanImage extends NetImage implements Serializable {
        private String thumbUrl;
        private String largeUrl;
        private int width;
        private int height;

        public HuaBanImage(String url, int width, int height) {
            this.thumbUrl = "http://img.hb.aicdn.com/"+url+"_fw236";
            this.largeUrl = "http://img.hb.aicdn.com/"+url;
            this.width = width;
            this.height = height;
        }

        @Override
        public String getThumbImg() {
            return thumbUrl;
        }

        @Override
        public String getLargeImg() {
            return largeUrl;
        }

        @Override
        public int getWidth() {
            return width;
        }

        @Override
        public int getHeight() {
            return height;
        }
    }

}
