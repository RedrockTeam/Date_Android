package com.mredrock.date.model.bean;

/**
 * Created by Mr.Jude on 2015/4/22.
 */
public class Banner {
    private String img;
    private String link;

    public Banner(String img, String link) {
        this.img = img;
        this.link = link;
    }

    public String getImg() {

        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
