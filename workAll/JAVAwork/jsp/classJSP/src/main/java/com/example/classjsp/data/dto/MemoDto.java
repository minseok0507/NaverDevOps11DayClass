package com.example.classjsp.data.dto;

import java.sql.Timestamp;

public class MemoDto {
    private int num;
    private String uploadPhoto;
    private String title;
    private String content;
    private Timestamp writeDay;


    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getUploadPhoto() {
        return uploadPhoto;
    }

    public void setUploadPhoto(String uploadPhoto) {
        this.uploadPhoto = uploadPhoto;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getWriteDay() {
        return writeDay;
    }

    public void setWriteDay(Timestamp writeDay) {
        this.writeDay = writeDay;
    }
}
