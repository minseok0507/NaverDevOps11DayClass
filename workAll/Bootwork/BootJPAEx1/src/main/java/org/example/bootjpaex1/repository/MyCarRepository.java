package org.example.bootjpaex1.repository;

import jakarta.transaction.Transactional;
import org.example.bootjpaex1.data.MycarDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MyCarRepository extends JpaRepository<MycarDto, Long> {
    @Modifying
    @Transactional
    @Query(value = """
            UPDATE mycar SET carname = :name, price = :price, color = :color
            WHERE id = :id
            """, nativeQuery = true)
    public void updateMycarNoPhoto(
            @Param("id") Long id,
            @Param("name") String name,
            @Param("price") Integer price,
            @Param("color") String color
    );

    @Modifying
    @Transactional
    @Query(value = """
        UPDATE mycar
        SET carname = :#{#dto.name},
            price = :#{#dto.price},
            color = :#{#dto.color}
        WHERE id = :#{#dto.id}
        """, nativeQuery = true)
    public void updateMycarNoPhoto(@Param("dto") MycarDto dto);

}
