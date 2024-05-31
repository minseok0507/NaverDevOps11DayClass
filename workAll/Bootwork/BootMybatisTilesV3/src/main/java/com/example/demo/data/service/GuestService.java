package com.example.demo.data.service;

import com.example.demo.data.dto.GuestDto;
import com.example.demo.data.dto.GuestPhotoDto;
import com.example.demo.data.mapper.GuestMapperInter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GuestService {
    private final GuestMapperInter guestMapperInter;

    public void insertGuest(GuestDto guestDto) {
        guestMapperInter.insertGuest(guestDto);
    }
    public void insertGuestPhoto(GuestPhotoDto guestPhotoDto) {
        guestMapperInter.insertGuestPhoto(guestPhotoDto);
    }
}
