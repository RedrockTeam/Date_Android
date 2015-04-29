package com.mredrock.date.model.bean;

/**
 * Created by Mr.Jude on 2015/4/22.
 */
public class Appointment {

    private int type;
    private String title;
    private String address;
    private long date;
    private String cost;
    private String grade;
    private int gender;
    private String college;
    private int count;
    private long  releaseTime;
    private PersonBrief author;

    public PersonBrief getAuthor() {
        return author;
    }

    public void setAuthor(PersonBrief author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public long getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(long releaseTime) {
        this.releaseTime = releaseTime;
    }
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Appointment(PersonBrief author,String title, String address, long date, String cost, String grade, int gender, String college, int count, long releaseTime) {
        this.author = author;
        this.title = title;
        this.address = address;
        this.date = date;
        this.cost = cost;
        this.grade = grade;
        this.gender = gender;
        this.college = college;
        this.count = count;
        this.releaseTime = releaseTime;
    }

    public Appointment() {
    }
}
