package com.example.demo.controller.board;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardListController {
    @GetMapping("board/list")
    public String boardList(Model model) {
        return "board/boardlist";
    }
}
