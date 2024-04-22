package com.minseok.shop.controller;

import com.minseok.shop.model.CustomUser;
import com.minseok.shop.model.Member;
import com.minseok.shop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    String login(Authentication auth) {
        if (auth != null && auth.isAuthenticated()) {
            return "redirect:/";
        } else {
            return "login.html";
        }
    }


    @GetMapping("/logout")
    String logout() {
        return "redirect:/"; // 홈 페이지로 리다이렉트
    }

    @PostMapping("/logout")
    public String performLogout() {

        return "redirect:/";
    }

    @PostMapping("/signup")
    String singup(String username, String password, String displayName) {
        if (password.length() >= 6) {
            Member member = new Member();
            member.username = username;
            var hash = passwordEncoder.encode(password);
            member.password = hash;
            member.displayName = displayName;

            System.out.println(member);
            memberRepository.save(member);
        } else {
            return "redirect:/signup";
        }
        return "redirect:/login";
    }


    @GetMapping("/my-page")
    public String myPage(Authentication auth) {
        if (auth.isAuthenticated()) {
            System.out.println(auth.getPrincipal());
            var result = (CustomUser) auth.getPrincipal();
            System.out.println(result.displayName);
            return "mypage.html";

        }

        return "/";
    }

}
