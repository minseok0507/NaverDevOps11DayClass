package com.example.demo.data.service;

import com.example.demo.data.dto.BoardDto;
import com.example.demo.data.mapper.BoardMapperInter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PagingService {
    private final BoardMapperInter boardMapper;

    public List<BoardDto> getBoardPage(int pageNo) {
        return boardMapper.getBoardPage((pageNo - 1) * 10, 10);
    }

}
