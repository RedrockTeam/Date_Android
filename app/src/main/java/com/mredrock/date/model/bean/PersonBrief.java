package com.mredrock.date.model.bean;

/**
 * Created by Mr.Jude on 2015/4/28.
 */
public class PersonBrief {
    private String face;
    private String name;
    private String sign;
    private int grade;

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public PersonBrief(String face, String name, String sign, int grade) {
        this.face = face;
        this.name = name;
        this.sign = sign;
        this.grade = grade;
    }
}
