package com.example.demoretrofit2.model;

import com.google.gson.annotations.SerializedName;

public class AudioBook {
    @SerializedName("id")
    private String id;

    @SerializedName("name")
    private String name;

    @SerializedName("partCount")
    private int partCount;

    @SerializedName("author")
    private String author;

    @SerializedName("translator")
    private String translator;

    @SerializedName("isRecommend")
    private boolean isRecommend;

    @SerializedName("status")
    private String status;

    @SerializedName("viewCount")
    private int viewCount;

    @SerializedName("likeCount")
    private int likeCount;

    public AudioBook() {
    }

    public AudioBook(String id, String name, int partCount, String author, String translator, boolean isRecommend, String status, int viewCount, int likeCount) {
        this.id = id;
        this.name = name;
        this.partCount = partCount;
        this.author = author;
        this.translator = translator;
        this.isRecommend = isRecommend;
        this.status = status;
        this.viewCount = viewCount;
        this.likeCount = likeCount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPartCount() {
        return partCount;
    }

    public void setPartCount(int partCount) {
        this.partCount = partCount;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTranslator() {
        return translator;
    }

    public void setTranslator(String translator) {
        this.translator = translator;
    }

    public boolean isRecommend() {
        return isRecommend;
    }

    public void setRecommend(boolean recommend) {
        isRecommend = recommend;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }
}
