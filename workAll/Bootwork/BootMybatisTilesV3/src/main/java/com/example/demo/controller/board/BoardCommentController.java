package com.example.demo.controller.board;

import com.example.demo.data.dto.BoardCommentDto;
import com.example.demo.data.service.BoardCommentService;
import com.example.demo.data.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class BoardCommentController {
    private final BoardCommentService boardCommentService;

    @GetMapping("/comment/get")
    @ResponseBody
    public ResponseEntity<List<BoardCommentDto>> postComment(
            @RequestParam("boardId") int boardId
    ) {
        List<BoardCommentDto> list = boardCommentService.selectAllByBoard(boardId);

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("/comment/insert")
    public ResponseEntity<Map<String, Object>> insertComment(
            @RequestBody BoardCommentDto boardCommentDto
    ) {
        System.out.println(boardCommentDto);
        try {
            boardCommentService.insertComment(boardCommentDto);
            Map<String, Object> response = new HashMap<>();
            response.put("status", "success");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            Map<String, Object> response = new HashMap<>();
            response.put("status", "error");
            response.put("message", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

}
