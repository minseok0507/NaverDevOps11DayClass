package com.example.demo.controller.board;

import com.example.demo.data.dto.BoardDto;
import com.example.demo.data.service.BoardService;
import com.example.demo.data.service.MemberService;
import com.example.demo.data.service.PagingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BoardListController {
    private final BoardService boardService;
    private final PagingService pagingService;

    @GetMapping("board/list")
    public String boardList(
            @RequestParam(defaultValue = "1") int page,
            Model model) {
        List<BoardDto> boardDtoList = pagingService.getBoardPage(page);
        int countMember = boardService.getBoardCountAll();

        int maxPage = (int) Math.ceil((double) countMember /3);
//        System.out.println(maxPage);
        model.addAttribute("boardDtoList", boardDtoList);
        model.addAttribute("countMember", countMember);
        model.addAttribute("page", page);
        model.addAttribute("maxPage", maxPage);

        return "board/boardlist";
    }




}
