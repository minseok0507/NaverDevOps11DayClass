package com.minseok.shop.repository;

import com.minseok.shop.model.CartItem;
import com.minseok.shop.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Orders, Long> {
}
