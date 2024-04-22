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


    public CartDto(CartItem cartItem, Item item){
        this.id = cartItem.getId();
        this.userId = cartItem.getUserId();
        this.itemId = cartItem.getItemId();
        this.quantity = cartItem.getQuantity();
        this.itemTitle = item.getTitle();
        this.itemPrice = item.getPrice();
        this.itemUrl = item.getUrl();
    }
}


