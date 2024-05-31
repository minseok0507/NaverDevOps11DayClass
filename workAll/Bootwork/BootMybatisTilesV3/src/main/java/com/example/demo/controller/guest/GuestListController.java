package com.example.demo.controller.guest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GuestListController {
    @GetMapping("guest/list")
    public String list() {
        return "guest/guestlist";
    }

    @GetMapping("/guest/test")
    public String test() {
        return "guest/test";
    }

    // Java (Spring Controller)
    @PostMapping("/save-content")
    @ResponseBody
    public ResponseEntity<Void> saveContent(@RequestBody String content) {
        // 에디터 내용을 데이터베이스 또는 파일에 저장하는 로직 구현
//        System.out.println(content);
//        contentService.saveContent(content);
        System.out.println(content.toString());
        return ResponseEntity.ok().build();
    }

}
