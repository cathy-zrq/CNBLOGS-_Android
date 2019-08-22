package com.example.lenovo.myapplication.entity;

import java.util.Date;

/**
 * Created by lenovo on 2019/8/17.
 */

public class LatestNews {
    private String id;
    private String newTitle;
    private Date publishedTime;
    private String sourceName;
    private String summary;
    private Integer numberOfView;
    private Integer numberOfComments;
    private Integer numberOfDiggs;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getPublishedTime() {
        return publishedTime;
    }

    public void setPublishedTime(Date publishedTime) {
        this.publishedTime = publishedTime;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Integer getNumberOfView() {
        return numberOfView;
    }

    public void setNumberOfView(Integer numberOfView) {
        this.numberOfView = numberOfView;
    }

    public Integer getNumberOfComments() {
        return numberOfComments;
    }

    public void setNumberOfComments(Integer numberOfComments) {
        this.numberOfComments = numberOfComments;
    }

    public Integer getNumberOfDiggs() {
        return numberOfDiggs;
    }

    public void setNumberOfDiggs(Integer numberOfDiggs) {
        this.numberOfDiggs = numberOfDiggs;
    }

    public String getNewTitle() {
        return newTitle;
    }

    public void setNewTitle(String newTitle) {
        this.newTitle = newTitle;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }
}
