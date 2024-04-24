package com.minseok.shop.repository;

import com.minseok.shop.model.OrderNew;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderNewRepository extends JpaRepository<OrderNew, Long> {
// fetch join을 사용한 쿼리
    @Query("SELECT o FROM OrderNew o JOIN FETCH o.member JOIN FETCH o.item")
    List<OrderNew> findAllWithMemberAndItem();

}