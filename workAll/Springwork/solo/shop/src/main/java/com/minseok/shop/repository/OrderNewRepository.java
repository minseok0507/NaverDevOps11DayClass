package com.minseok.shop.repository;

import com.minseok.shop.model.OrderNew;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderNewRepository extends JpaRepository<OrderNew, Long> {

}
