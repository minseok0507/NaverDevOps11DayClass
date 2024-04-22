package com.minseok.shop.repository;

import com.minseok.shop.model.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface noticeRepository extends JpaRepository<Notice, Integer> {

}
