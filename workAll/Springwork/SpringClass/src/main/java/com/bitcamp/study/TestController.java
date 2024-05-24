package com.bitcamp.study;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Locale;

@Controller
public class TestController {
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(Locale locale, Model model) {

        model.addAttribute("msg", "TESTtestTest앙앙앙");



        return "test";
    }
}
