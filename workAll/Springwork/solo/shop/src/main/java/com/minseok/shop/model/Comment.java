package com.minseok.shop.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String username;

    //댓글 제한 1000글자
    @Column(length = 1000)
    public String content;

    public LocalDateTime dateTime;

    //itemID
    public Long parentId;


}