package com.minseok.shop.repository;

import com.minseok.shop.model.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByParentId(Long parentId);
    Page<Comment> findByParentId(Long parentId, PageRequest page);

}
