package org.example.entity;

public class Message {


    public Integer getMessageID() {
        return messageID;
    }

    public void setMessageID(Integer messageID) {
        this.messageID = messageID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getmLike() {
        return mLike;
    }

    public void setmLike(Integer mLike) {
        this.mLike = mLike;
    }

    private Integer messageID;
    private String userName;
    private String placeName;
    private String text;
    private Integer mLike;
}
