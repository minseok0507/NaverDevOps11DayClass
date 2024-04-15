package com.minseok.shop.item;

import jakarta.persistence.*;
import lombok.ToString;
import org.springframework.core.io.FileUrlResource;

@Entity
@ToString
@Table(indexes = @Index(columnList = "title", name = "작명"))
public class Item{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String title;

    public Integer price;

    public String writeUserId;

    @Lob
    public String url;

}

