package com.minseok.shop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class BasicController {
    @GetMapping("/")
    String go() {
        return "index.html";
    }

    @GetMapping("/date")
    @ResponseBody
    String date() {
        Date date = new Date();
        return date.toString();
    }
}
