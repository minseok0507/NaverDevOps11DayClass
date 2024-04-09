package com.minseok.shop.member;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.net.Authenticator;
import java.security.Principal;

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

    @PostMapping("/signup")
    String singup(String username, String password, String displayName) {
        if (password.length() >= 8) {
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
