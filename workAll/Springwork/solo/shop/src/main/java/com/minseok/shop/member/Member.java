package com.minseok.shop.member;

import jakarta.persistence.*;
import lombok.ToString;

@Entity
@ToString
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(unique = true)
    public String username;

    public String password;

    public String displayName;
}
