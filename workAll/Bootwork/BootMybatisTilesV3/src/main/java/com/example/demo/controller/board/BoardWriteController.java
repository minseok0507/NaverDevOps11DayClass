package com.example.demo.controller.board;

import com.example.demo.data.dto.BoardDto;
import com.example.demo.data.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Objects;

@Controller
@RequiredArgsConstructor
public class BoardWriteController {
    private final BoardService boardService;

    @GetMapping("board/write")
    public String wirte() {
        return "board/board-write";
    }

    @PostMapping("board/write/action")
    public String action(
            @RequestParam("title") String title,
            @RequestParam("content") String content,
            HttpServletRequest request
    ) {
        HttpSession session = request.getSession();
        String writeUser = (String) session.getAttribute("myid");

        int check = boardService.insertBoard(title, content, writeUser);
        if (check == 0) {
            return "error";
        } else {
            return "redirect:/board/list";
        }
    }


    @GetMapping("board/reply")
    public String reply(
            @RequestParam("id") int id,
            Model model
    ) {
        model.addAttribute("id", id);
        BoardDto dto = boardService.selectById(id);
        model.addAttribute("dto", dto);
        return "board/board-reply";
    }

    @PostMapping("board/reply/action")
    public String replyAction(
            @RequestParam("parentId") int parentId,
            @RequestParam("title") String title,
            @RequestParam("content") String content,
            HttpServletRequest request
    ){
        HttpSession session = request.getSession();
        String writeUser = (String) session.getAttribute("myid");

        int check = boardService.insertBoard(parentId, title, content, writeUser);
        if (check == 0) {
            return "error";
        } else {
            return "redirect:/board/list";
        }

    }

    @GetMapping("board/update")
    public String update(
            @RequestParam("id") int id,
            HttpServletRequest request,
            Model model
    ){
        HttpSession session = request.getSession();
        String myid = (String) session.getAttribute("myid");
        BoardDto boardDto = boardService.selectById(id);
        if(!Objects.equals(boardDto.getWriteUser(), myid)){
            return "error";
        }
        model.addAttribute("dto", boardDto);
        return "board/update";
    }

    @GetMapping("board/update/action")
    public String updateAction(
            @RequestParam("id") int id,
            @RequestParam("title") String title,
            @RequestParam("content") String content
    ){
        boardService.updateBoard(title, content, id);

        return "redirect:/board/detail?id=" + id;
    }



}
