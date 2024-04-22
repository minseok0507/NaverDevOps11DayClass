package com.minseok.shop.controller;

import com.minseok.shop.repository.CommentRepository;
import com.minseok.shop.model.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;

@Controller
@RequiredArgsConstructor
public class CommentController {
    private final CommentRepository commentRepository;

    private void commentAdd(Long parentId, String username, String content) {
        Comment comment = new Comment();
        comment.parentId = parentId;
        comment.username = username;
        comment.content = content;
        comment.dateTime = LocalDateTime.now();

        commentRepository.save(comment);
    }

    //댓글 추가 엑션
    @PostMapping("/comment")
    String comment(Long parentId, String username, String content) {
        if (content.equalsIgnoreCase("") || username == null) {
            return "redirect:/detail/" + parentId;
        }
        commentAdd(parentId, username, content);


        return "redirect:/detail/" + parentId;
    }
}
