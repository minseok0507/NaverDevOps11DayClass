package com.bitcamp.study;

import java.util.Date;
import java.util.Locale;

import dto.ShopDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Locale locale, Model model) {

        return "start";
    }

    @GetMapping("/board/list")
    public String home1(Locale locale, Model model) {
        model.addAttribute("msg","hihihihih");
        return "result1";
    }

    @GetMapping("/guest/list")
    public ModelAndView home2() {
        ModelAndView mav = new ModelAndView("guest");
        mav.addObject("msg","hihihihih");
        mav.setViewName("result2");
        
        return mav;
    }

}
