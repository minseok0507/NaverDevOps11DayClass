package com.minseok.shop.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.core.io.FileUrlResource;

@Entity
@ToString
@Getter
@Setter
@Table(indexes = @Index(columnList = "title", name = "작명"))
public class Item{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String title;

    public Long price;

    public String writeUserId;

    @Lob
    public String url;

}

