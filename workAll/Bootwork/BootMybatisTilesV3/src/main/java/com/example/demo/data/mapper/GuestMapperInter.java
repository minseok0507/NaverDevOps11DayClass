package com.example.demo.data.mapper;

import com.example.demo.data.dto.GuestDto;
import com.example.demo.data.dto.GuestPhotoDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GuestMapperInter {
    public void insertGuest(GuestDto guestDto);
    public void insertGuestPhoto(GuestPhotoDto guestPhotoDto);
}
