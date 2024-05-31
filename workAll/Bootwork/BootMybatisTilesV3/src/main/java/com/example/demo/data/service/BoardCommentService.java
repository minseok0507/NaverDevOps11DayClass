package com.example.demo.data.service;

import com.example.demo.data.dto.BoardCommentDto;
import com.example.demo.data.mapper.BoardCommentMapperInter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardCommentService {
    private final BoardCommentMapperInter boardCommentMapperInter;

    public List<BoardCommentDto> selectAllByBoard(int boardId) {
        return boardCommentMapperInter.selectAllByBoard(boardId);
    }

    public void insertComment(BoardCommentDto boardCommentDto) {
        boardCommentMapperInter.insertComment(boardCommentDto);
    }

}
