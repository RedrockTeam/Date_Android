package com.mredrock.date.model.bean;

/**
 * Created by Administrator on 2015/5/27.
 */
public class PersonInformatin {
    private String face;
    private String name;
    private String sign;
    private int grade;
    private String xueyuan;
    private String tel;
    private String qq;
    private String weixin;

    public PersonInformatin(String face, String name, String sign, int grade, String xueyuan, String tel, String qq, String weixin) {
        this.face=face;
        this.name=name;
        this.grade=grade;
        this.sign=sign;
        this.xueyuan = xueyuan;
        this.tel = tel;
        this.qq = qq;
        this.weixin = weixin;
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

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getXueyuan() {
        return xueyuan;
    }

    public void setXueyuan(String xueyuan) {
        this.xueyuan = xueyuan;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getWeixin() {
        return weixin;
    }

    public void setWeixin(String weixin) {
        this.weixin = weixin;
    }
}
