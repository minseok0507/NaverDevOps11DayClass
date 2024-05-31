package com.example.demo.data.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.sql.Timestamp;

@NoArgsConstructor
@Data
@Alias("GuestDto")
@Builder
@AllArgsConstructor
public class GuestDto {
    private int guestidx;
    private String writer;
    private String myid;
    private String gcontent;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
    private Timestamp writeday;
}
