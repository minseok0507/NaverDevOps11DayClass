package com.minseok.shop.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class OrderDto {
    private Long orderId;
    private String itemTitle;
    private String userName;
    private Integer quantity;
    private LocalDateTime orderDate;
    private String orderStatus;

}
