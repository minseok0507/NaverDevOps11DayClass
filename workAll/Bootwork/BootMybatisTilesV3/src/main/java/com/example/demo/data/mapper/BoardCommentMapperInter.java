package com.example.demo.data.mapper;

import com.example.demo.data.dto.BoardCommentDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BoardCommentMapperInter {
    @Select("select * from board_comments where board_id = #{boardId} order by ref, step;")
    @ResultMap("boardCommentResultMap")
    List<BoardCommentDto> selectAllByBoard(@Param("boardId") int boardId);


    void insertComment(BoardCommentDto boardCommentDto);
}