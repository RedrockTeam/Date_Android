package com.mredrock.date.model.bean;

/**
 * Created by Mr.Jude on 2015/4/22.
 */
public class Appointment {
    public static final String[] COSTMODEL = {"你掏钱","AA制","我请客"};

    private String nickname;
    private String head;
    private int gender;
    private String date_id;
    private String user_id;
    private long created_at;
    private long date_at;
    private String place;
    private String title;
    private int cost_model;
    private String signature;
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getDate_id() {
        return date_id;
    }

    public void setDate_id(String date_id) {
        this.date_id = date_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public long getCreated_at() {
        return created_at;
    }

    public void setCreated_at(long created_at) {
        this.created_at = created_at;
    }

    public long getDate_at() {
        return date_at;
    }

    public void setDate_at(long date_at) {
        this.date_at = date_at;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public int getCost_model() {
        return (--cost_model)<0?0:cost_model;
    }

    public void setCost_model(int cost_model) {
        this.cost_model = cost_model;
    }
}
