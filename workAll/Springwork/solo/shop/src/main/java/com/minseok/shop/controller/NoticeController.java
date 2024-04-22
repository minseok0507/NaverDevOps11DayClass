package com.minseok.shop.controller;

import com.minseok.shop.model.Notice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class NoticeController {

    private final com.minseok.shop.repository.noticeRepository noticeRepository;



    @GetMapping("/note")
    String list(Model model) {

        List<Notice> notes = noticeRepository.findAll();


        model.addAttribute("notes", notes);
        return "notice.html";
    }
}
