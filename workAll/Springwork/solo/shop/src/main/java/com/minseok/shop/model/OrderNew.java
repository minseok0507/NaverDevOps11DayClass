package com.minseok.shop.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
public class OrderNew {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(
            name = "userId",
            foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT)
    )
    private Member member;

    @ManyToOne
    @JoinColumn(
            name = "itemId",
            foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT)
    )
    private Item item;

    private Integer quantity;

    @CreationTimestamp
    private LocalDateTime orderDate;

    private String orderStatus;

}
