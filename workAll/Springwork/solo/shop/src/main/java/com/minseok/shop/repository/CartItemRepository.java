package com.minseok.shop.repository;

import com.minseok.shop.model.CartDto;
import com.minseok.shop.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    //    //카트 추가 시 본인 카트에 해당 아이템이 있나 확인
//    @Query("SELECT c FROM CartItem c WHERE c.userId = :userId AND c.itemId = :itemId")
//    Optional<CartItem> findByUserId(Long userId, Long itemId); // 쿼리 수정
//
//    List<CartItem> findAllByItemId(Long itemId);
//    List<CartItem> findAllByUserId(Long userId);
    @Query("SELECT c FROM CartItem c WHERE c.member.id = :userId AND c.item.id = :itemId")
    Optional<CartItem> findCartItemsByUserIdAndItemId(@Param("userId") Long userId, @Param("itemId") Long itemId);

    @Query("SELECT c FROM CartItem c WHERE c.member.id = :userId")
    List<CartItem> findCartItemsByUserId(@Param("userId") Long userId);

    @Modifying
    @Query("UPDATE CartItem c SET c.quantity = c.quantity + :quantity WHERE c.member.id = :userId AND c.item.id = :itemId")
    int updateQuantityForUserAndItem(Long userId, Long itemId, Integer quantity);
}
