package com.example.demo.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@NoArgsConstructor
@Data
@Alias("BoardDto")
@Builder
@AllArgsConstructor
public class BoardDto {
    private int id;
    private String boardTitle;
    private String boardContent;
    private Timestamp boardDate;
    private String writeUser;
    private int viewCount;
    private int recommendCount;
    private int ref;
    private int step;
    private int level;
    private int commentCount;
}
