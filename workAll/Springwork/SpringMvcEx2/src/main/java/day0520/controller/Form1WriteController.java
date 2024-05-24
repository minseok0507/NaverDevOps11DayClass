package day0520.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Form1WriteController {
    @GetMapping("/read1")
    public String read1(
            @RequestParam String name,
            @RequestParam String addr,
            @RequestParam int age,
            Model model) {

        model.addAttribute("name", name);
        model.addAttribute("addr", addr);
        model.addAttribute("age", age);
        model.addAttribute("info", age >= 20 ? "성인" : "미성년자");

        return "/form1/result1";
    }
}
