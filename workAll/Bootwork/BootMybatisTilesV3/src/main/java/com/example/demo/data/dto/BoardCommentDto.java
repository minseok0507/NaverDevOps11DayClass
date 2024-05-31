package com.example.demo.data.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.sql.Timestamp;

@NoArgsConstructor
@Data
@Alias("BoardCommentDto")
@Builder
@AllArgsConstructor
public class BoardCommentDto {
    private int commentId;
    private int boardId;
    private String commentText;
    private Timestamp commentDate;
    private String commentUser;
    private int ref;
    private int step;
    private int level;
}
