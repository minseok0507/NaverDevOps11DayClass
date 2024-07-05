package org.example.bootjpaex1.repository;

import org.example.bootjpaex1.data.MyCarCommentDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MyCarCommentRepository extends JpaRepository<MyCarCommentDto, Long> {
    @Query(value = "select * from comment where mycar_id = :MycarId order by id desc ",nativeQuery = true)
    public List<MyCarCommentDto> findByCarId(@Param("MycarId")Long MycarId);
}
