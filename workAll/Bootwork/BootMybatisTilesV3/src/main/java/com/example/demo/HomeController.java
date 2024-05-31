package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

	@GetMapping("/")
	public String home(
			HttpSession session,
			Model model
	)
	{
		model.addAttribute("session", session.getAttribute("myid"));
		return "layout/main";
	}
}
