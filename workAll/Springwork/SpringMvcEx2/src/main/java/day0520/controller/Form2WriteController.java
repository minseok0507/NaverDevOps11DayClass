package day0520.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Form2WriteController {
    @PostMapping("/read2")
    public String read2(
            String name,
            String addr,
            int age,
            Model model) {

        model.addAttribute("name", name);
        model.addAttribute("addr", addr);
        model.addAttribute("age", age);
        model.addAttribute("info", age >= 20 ? "폼2 성인" : "폼2 미성년자");

        return "/form2/result2";
    }
}
