package com.example.classjsp;

public class ShopDto {
    private String name;
    private String photo;
    private String color;
    private int price;
    private int count;


    public ShopDto() {
        super();
    }

    public ShopDto(String name, String photo, String color, int price, int count) {
        this.name = name;
        this.photo = photo;
        this.color = color;
        this.price = price;
        this.count = count;
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
}

