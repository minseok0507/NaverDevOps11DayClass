package org.example.bootjpaex1.data;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "mycar")
public class MycarDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "carname", length = 30)
    private String name;

    private int price;

    @Column(length = 20)
    private String color;

    @Column(length = 100)
    private String photo;

    private String buy;

    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp createAt;

//  테이블 컬럼 생성 x
    @Transient
    private int commentCount;
    @Transient
    private String message;
}
