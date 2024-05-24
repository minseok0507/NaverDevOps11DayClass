package day0520.controller;

import day0520.dto.FoodDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class Form4WriteController {
    @PostMapping("/read4")
    public String read4(
            @RequestParam Map<String, String> map,
            Model model
    ) {

        model.addAttribute("name", map.get("name"));
        model.addAttribute("photo", map.get("photo"));
        model.addAttribute("price", map.get("price"));
        model.addAttribute("count", map.get("count"));


        return "/form4/result4";
    }
}
