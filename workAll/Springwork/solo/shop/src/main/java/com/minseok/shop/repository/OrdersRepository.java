package com.minseok.shop.repository;

import com.minseok.shop.model.CartItem;
import com.minseok.shop.model.OrderDto;
import com.minseok.shop.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrdersRepository extends JpaRepository<Orders, Long> {

}
