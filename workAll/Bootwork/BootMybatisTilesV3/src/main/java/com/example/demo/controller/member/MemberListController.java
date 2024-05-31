package com.example.demo.controller.member;

import com.example.demo.data.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class MemberListController {
	
	@NonNull
	private MemberService memberService;
	
	@GetMapping("/member/list")
	public String memberList(Model model)
	{
		int totalCount=memberService.getTotalCount();
		model.addAttribute("totalCount",totalCount);
		model.addAttribute("memberList", memberService.selectAll());
		
		return "member/memberlist";
	}

}







