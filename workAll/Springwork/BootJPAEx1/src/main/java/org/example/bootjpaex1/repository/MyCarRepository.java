package org.example.bootjpaex1.repository;

import org.example.bootjpaex1.data.MycarDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyCarRepository extends JpaRepository<MycarDto, Long> {

}
