package com.minseok.shop.notice;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.ToString;

import java.util.Date;

@Entity
@ToString
public class Notice {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    public String 글제목;

    public Date 날짜;
}
