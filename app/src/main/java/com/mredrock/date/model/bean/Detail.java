package com.mredrock.date.model.bean;

import java.util.ArrayList;
import java.util.List;

public class Detail {
    public static final String[] SEX = {"无限制", "男", "女"};
    public static final String[] GRAD = {"无限制", "大一", "大二", "大三", "大四", "其它"};
    public static final String[] COLLECTION = {"收藏", "已收藏"};
    public static final String[] REPORT = {"报名", "已报名"};

    private String nickname;
    private String head;
    private String gender;
    private int date_id;
    private int user_id;
    private String created_at;
    private long date_at;
    private String place;
    private String title;
    private String content;
    private int date_type;
    private String type;
    private int people_limit;
    private String category_id;
    private int gender_limit;
    private int cost_model = -1;
    private String signature;
    private int grade_limit[];
    private int collection_status;
    private int apply_status;
    private List<Join> joined = new ArrayList<Join>();
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

    public int[] getGrade_limit() {
        return grade_limit;
    }

    public void setGrade_limit(int[] grade_limit) {
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

    public int getApply_status() {
        return apply_status;
    }

    public void setApply_status(int apply_status) {
        this.apply_status = apply_status;
    }

    public int getCollection_status() {
        return collection_status;
    }

    public void setCollection_status(int collection_status) {
        this.collection_status = collection_status;
    }

    public void setUser_score(double user_score) {
        this.user_score = user_score;
    }

    public List<Join> getJoined() {
        return joined;
    }

    public void setJoined(List<Join> joined) {
        this.joined = joined;
    }

    public class Join {
        private int user_id;
        private int date_id;
        private String nickname;
        private int gender;
        private String signature;
        private String head;

        public int getDate_id() {
            return date_id;
        }

        public void setDate_id(int date_id) {
            this.date_id = date_id;
        }

        public int getGender() {
            return gender;
        }

        public void setGender(int gender) {
            this.gender = gender;
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

        public String getSignature() {
            return signature;
        }

        public void setSignature(String signature) {
            this.signature = signature;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }
    }
}
