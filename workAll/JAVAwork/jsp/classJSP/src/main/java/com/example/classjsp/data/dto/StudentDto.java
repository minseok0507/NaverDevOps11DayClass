package com.example.classjsp.data.dto;

import java.sql.Date;

public class StudentDto {
    private int num;
    private String name;
    private String blood;
    private Boolean license;
    private int java;
    private int spring;
    private int html;
    private Date writeday;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

    public Boolean getLicense() {
        return license;
    }

    public void setLicense(Boolean license) {
        this.license = license;
    }

    public int getJava() {
        return java;
    }

    public void setJava(int java) {
        this.java = java;
    }

    public int getSpring() {
        return spring;
    }

    public void setSpring(int spring) {
        this.spring = spring;
    }

    public int getHtml() {
        return html;
    }

    public void setHtml(int html) {
        this.html = html;
    }

    public Date getWriteday() {
        return writeday;
    }

    public void setWriteday(Date writeday) {
        this.writeday = writeday;
    }
}