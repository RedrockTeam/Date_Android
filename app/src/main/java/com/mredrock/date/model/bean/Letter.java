package com.mredrock.date.model.bean;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Lecion on 5/5/15.
 */
public class Letter implements Parcelable{
    @SerializedName("user_id")
    private int userId;
    @SerializedName("user_name")
    private String userName;
    @SerializedName("user_signature")
    private String userSignature;
    @SerializedName("user_avatar")
    private String userAvatar;
    @SerializedName("userGender")
    private int userGender;
    @SerializedName("content")
    private String content;
    @SerializedName("data_id")
    private int dateId;
    @SerializedName("letter_status")
    private LetterStatus letterStatus;
    @SerializedName("user_date_status")
    private int userDateStatus;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSignature() {
        return userSignature;
    }

    public void setUserSignature(String userSignature) {
        this.userSignature = userSignature;
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    public int getUserGender() {
        return userGender;
    }

    public void setUserGender(int userGender) {
        this.userGender = userGender;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getDateId() {
        return dateId;
    }

    public void setDateId(int dateId) {
        this.dateId = dateId;
    }

    public LetterStatus getLetterStatus() {
        return letterStatus;
    }

    public void setLetterStatus(LetterStatus letterStatus) {
        this.letterStatus = letterStatus;
    }

    public int getUserDateStatus() {
        return userDateStatus;
    }

    public void setUserDateStatus(int userDateStatus) {
        this.userDateStatus = userDateStatus;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    public enum LetterStatus {
        UNREAD(1), READ(2);
        private int value;

        private LetterStatus(int value) {
            this.value = value;
        }

        public int value() {
            return this.value;
        }

        public static LetterStatus valueOf(int value) {
            switch (value) {
                case 1:
                    return UNREAD;
                case 2:
                    return READ;
                default:
                    return null;
            }
        }
    }

}