package com.example.demo.data.service;

import com.example.demo.data.dto.BoardDto;
import com.example.demo.data.mapper.BoardMapperInter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Pageable;
import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class BoardService {
    private final BoardMapperInter boardMapper;

    public BoardDto selectById(int id) {
        return boardMapper.selectById(id);
    }

    public List<BoardDto> selectAll() {
        return boardMapper.selectAll();
    }

    public int getBoardCountAll() {
        return boardMapper.getBoardCountAll();
    }

    @Transactional
    public int insertBoard(String title, String content, String writerUser) {
        if (writerUser == null || writerUser.equals("")) {
            return -1;
        }
        BoardDto boardDto = new BoardDto();
        boardDto.setBoardTitle(title);
        boardDto.setBoardContent(content);
        boardDto.setWriteUser(writerUser);


        int result = boardMapper.insertBoard(boardDto);
        if (result > 0 && boardDto.getRef() == 0) {
            boardMapper.updateRef(boardDto);
        }
        return result;
    }

    @Transactional
    public int insertBoard(int parentId, String title, String content, String writerUser) {
        if (writerUser == null || writerUser.equals("")) {
            return -1;
        }
        BoardDto parentDto = boardMapper.selectById(parentId);
        BoardDto boardDto = new BoardDto();
        boardDto.setBoardTitle(title);
        boardDto.setBoardContent(content);
        boardDto.setWriteUser(writerUser);
        boardDto.setRef(parentDto.getRef());
        boardDto.setStep(parentDto.getStep() + 1);
        boardMapper.updateStep(parentDto.getRef(), boardDto.getStep());
        boardDto.setLevel(parentDto.getLevel() + 1);

        return boardMapper.insertBoard(boardDto);
    }


    public void updateViewCount(int id) {
        boardMapper.updateViewCount(id);
    }

    public void updateBoard(String title, String content, int id) {
        boardMapper.updateBoard(title, content, id);
    }


}
