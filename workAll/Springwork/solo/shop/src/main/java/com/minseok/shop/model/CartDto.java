package com.minseok.shop.model;


import com.minseok.shop.repository.ItemRepository;
import lombok.Getter;

@Getter
public class CartDto{

    private Long id;
    private Long userId;
    private Long itemId;
    private Integer quantity;
    private String itemTitle;
    private  Long itemPrice;
    private String itemUrl;


}


