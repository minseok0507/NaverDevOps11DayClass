package com.example.classjsp.data.dto;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class ShopDto {
    private Long id;
    private String name;
    private int price;
    private int count;
    private String color;
    private String photo;
    private Timestamp writeday;


    public ShopDto() {
        super();
    }

    public ShopDto(String name, int price, int count, String color, String photo){
        this.name = name;
        this.price = price;
        this.count = count;
        this.color = color;
        this.photo = photo;
    }



    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public int getPrice() {
        return price;
    }

    public String getColor() {
        return color;
    }

    public String getPhoto() {
        return photo;
    }

    public String getName() {
        return name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Timestamp getWriteday() {
        return writeday;
    }
    public void setWriteday(Timestamp writeday) {
        this.writeday = writeday;
    }
}

