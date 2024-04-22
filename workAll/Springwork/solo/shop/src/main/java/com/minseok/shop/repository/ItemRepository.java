package com.minseok.shop.repository;

import com.minseok.shop.model.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Long> {
    Page<Item> findPageBy(PageRequest page);

    //느린거
    List<Item> findByTitleContains(String title);
    //빠른거
    @Query(value = "SELECT * FROM shop.item WHERE match(title) against(:text);", nativeQuery = true)
    Page<Item> queryFindByPage(@Param("text") String text, Pageable pageable);

    @Query(value = "SELECT * FROM shop.item WHERE match(title) against(?1);", nativeQuery = true)
    List<Item> queryFindByTitle(String text);

    List<Item> findByIdIn(List<Long> ids);


}
