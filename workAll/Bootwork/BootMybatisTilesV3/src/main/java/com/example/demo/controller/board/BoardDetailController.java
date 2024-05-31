package com.example.demo.controller.board;

import com.example.demo.data.dto.BoardDto;
import com.example.demo.data.dto.MemberDto;
import com.example.demo.data.service.BoardService;
import com.example.demo.data.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequiredArgsConstructor
public class BoardDetailController {
    private final BoardService boardService;
    private final MemberService memberService;

    @GetMapping("/board/detail")
    public String boardDetail(
            @RequestParam int id,
            Model model
    ) {
        boardService.updateViewCount(id);
        BoardDto dto = boardService.selectById(id);
        MemberDto memberDto = memberService.selectByMyid(dto.getWriteUser());
        String Profile_photo = memberDto.getPhoto();

        model.addAttribute("profile_photo", Profile_photo);
        model.addAttribute("board", dto);

        return "board/detail";
    }
}
