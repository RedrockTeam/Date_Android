package com.mredrock.date.model.bean;

/**
 * Created by Mr.Jude on 2015/4/22.
 */
public class Appointment {
    private String title;
    private String address;
    private String date;
    private String cost;
    private String grade;
    private String gender;
    private String college;
    private String count;
    private long  releaseTime;

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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public long getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(long releaseTime) {
        this.releaseTime = releaseTime;
    }

    public Appointment(String title, String address, String date, String cost, String grade, String gender, String college, String count, long releaseTime) {

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
}
