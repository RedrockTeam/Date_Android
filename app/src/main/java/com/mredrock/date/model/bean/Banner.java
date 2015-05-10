package com.mredrock.date.model.bean;

/**
 * Created by Mr.Jude on 2015/4/22.
 */
public class Banner {
    private String src;
    private String url;

    public Banner(String img, String link) {
        this.src = img;
        this.url = link;
    }

    public String getSrc() {

        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
