package member.controller;

import lombok.RequiredArgsConstructor;
import member.dto.MemberDto;
import member.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class UpdateController {
    private final MemberService memberService;

    @GetMapping("/update")
    public String updateForm(
            @RequestParam("num") int num,
            Model model
    ) {
        MemberDto dto = memberService.findByNum(num);

        model.addAttribute("member", dto);

        return "member/update-form";
    }


    @PostMapping("/update/form-action")
    public String updateFormAction(
            @ModelAttribute MemberDto member
            ){

        memberService.updateMemberByDto(member);


        return "redirect:/member/detail?num=" + member.getNum();
    }

}
