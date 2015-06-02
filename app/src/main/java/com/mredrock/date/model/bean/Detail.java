package com.mredrock.date.model.bean;

public class Detail {
    public static final String[] SEX = {"无限制", "男","女"};

    private String nickname;
    private String head;
    private String gender;
    private int date_id;
    private int user_id;
    private String content;
    private String created_at;
    private long date_at;
    private String place;
    private String title;
    private int date_type;
    private String type;
    private int people_limit;
    private String category_id;
    private int gender_limit;
    private int cost_model = -1;
    private String signature;
    private String grade_limit[];
    private double user_score;

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getCost_model() {
        return cost_model;
    }

    public void setCost_model(int cost_model) {
        this.cost_model = cost_model;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public long getDate_at() {
        return date_at;
    }

    public void setDate_at(long date_at) {
        this.date_at = date_at;
    }

    public int getDate_id() {
        return date_id;
    }

    public void setDate_id(int date_id) {
        this.date_id = date_id;
    }

    public int getDate_type() {
        return date_type;
    }

    public void setDate_type(int date_type) {
        this.date_type = date_type;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getGender_limit() {
        return gender_limit;
    }

    public void setGender_limit(int gender_limit) {
        this.gender_limit = gender_limit;
    }

    public String[] getGrade_limit() {
        return grade_limit;
    }

    public void setGrade_limit(String[] grade_limit) {
        this.grade_limit = grade_limit;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getPeople_limit() {
        return people_limit;
    }

    public void setPeople_limit(int people_limit) {
        this.people_limit = people_limit;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public double getUser_score() {
        return user_score;
    }

    public void setUser_score(double user_score) {
        this.user_score = user_score;
    }
}
