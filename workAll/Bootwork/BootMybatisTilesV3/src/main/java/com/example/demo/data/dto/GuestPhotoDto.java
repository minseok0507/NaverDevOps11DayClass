package com.example.demo.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

@NoArgsConstructor
@Data
@Alias("GuestPhotoDto")
@Builder
@AllArgsConstructor
public class GuestPhotoDto {
    private int photoidx;
    private int guestidx;
    private String photoname;
}
