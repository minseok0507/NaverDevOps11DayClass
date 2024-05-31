package com.example.demo.controller.login;

import com.example.demo.data.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class LoginController {
    private final MemberService memberService;

    @GetMapping("/login")
    public String login() {
        return "member/login-form";
    }

    @GetMapping("/logout")
    public String logout(
            HttpServletRequest request
    ) {
        HttpSession session = request.getSession();
        session.setAttribute("login", "no");
        session.removeAttribute("myid");
        return "redirect:/";
    }

    @PostMapping("/login/action")
    public String login(
            @RequestParam("myid") String myid,
            @RequestParam("passwd") String passwd,
            HttpServletRequest request
    ) {
        int check = memberService.loginCheck(myid, passwd);
        System.out.println(check);
        if (check == 1) {
            HttpSession session = request.getSession();
            session.setAttribute("myid", myid);
            session.setAttribute("login", "yes");
            session.setMaxInactiveInterval(60 * 20);

            return "redirect:/";
        }else {

            return "redirect:/login";
        }

    }





}
