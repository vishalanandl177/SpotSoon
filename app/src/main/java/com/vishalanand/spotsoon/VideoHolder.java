package com.vishalanand.spotsoon;

/**
 * Created by Vishal Anand on 13-06-2017.
 */

public class VideoHolder {
    String img, title, detail, time;

    public VideoHolder() {
    }

    public VideoHolder(String img, String title, String detail, String time) {
        this.img = img;
        this.title = title;
        this.detail = detail;
        this.time = time;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
