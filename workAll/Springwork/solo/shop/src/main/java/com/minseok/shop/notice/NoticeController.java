package com.minseok.shop.notice;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class NoticeController {

    private final noticeRepository noticeRepository;



    @GetMapping("/note")
    String list(Model model) {

        List<Notice> notes = noticeRepository.findAll();


        model.addAttribute("notes", notes);
        return "notice.html";
    }
}