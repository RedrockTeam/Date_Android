package com.mredrock.date.model.bean;

/**
 * Created by Administrator on 2015/6/3.
 */
public class DateRecord {
    private String nickname;
    private String head;
    private String date_id;
    private String title;
    private String place;
    private String date_time;
    private String created_at;
    private String cost_model;
    private String date_status;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate_id() {
        return date_id;
    }

    public void setDate_id(String date_id) {
        this.date_id = date_id;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDate_time() {
        return date_time;
    }

    public void setDate_time(String date_time) {
        this.date_time = date_time;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getCost_model() {
        return cost_model;
    }

    public void setCost_model(String cost_model) {
        this.cost_model = cost_model;
    }

    public String getDate_status() {
        return date_status;
    }

    public void setDate_status(String date_status) {
        this.date_status = date_status;
    }
}
