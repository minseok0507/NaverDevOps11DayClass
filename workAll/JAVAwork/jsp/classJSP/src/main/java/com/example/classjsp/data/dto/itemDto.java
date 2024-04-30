package com.example.classjsp.data.dto;

public class itemDto {
    private int id;
    private String name;
    private String price;
    private String title;
    private String url;
    private String write_user_id;

    public itemDto() {
        super();
    }

    public itemDto(int id, String name, String price, String title, String url, String write_user_id) {
        this.id = id;
        this.price = price;
        this.title = title;
        this.url = url;
        this.write_user_id = write_user_id;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getWrite_user_id() {
        return write_user_id;
    }
    public void setWrite_user_id(String write_user_id) {
        this.write_user_id = write_user_id;
    }


}
