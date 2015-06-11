package com.mredrock.date.model.bean;

import java.io.Serializable;

/**
 * Created by Mr.Jude on 2015/6/11.
 */
public class DateType implements Serializable{
    int id;
    String type;

    public DateType() {
    }

    public DateType(int id, String type) {
        this.id = id;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
