package com.example.demo.controller.member;

import com.example.demo.data.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class MemberDetailController {

    private final MemberService memberService;

    @GetMapping("/member/detail")
    public String memberDetail(
            @RequestParam int num,
            Model model
    ) {
        model.addAttribute("member", memberService.getMemberById(num));

        return "member/member-detail";
    }


    @PostMapping("/member/photoupdate")
    @ResponseBody
    public String photoUpdate(
            @RequestParam("num") int num,
            @RequestParam("photofile") MultipartFile photofile,
            HttpServletRequest request
    ) {
        String realFolder = request.getSession().getServletContext().getRealPath("/upload-img");
        String originalFilename = photofile.getOriginalFilename(); //같은 서버에 같은 파일명으로 업로드 하면 덮어쓰기 됨
        String fileExtension = "";
        int lastIndex = originalFilename.lastIndexOf(".");
        if (lastIndex != -1) {
            fileExtension = originalFilename.substring(lastIndex); // 파일 확장자 가져오기
        }
        String fileName = UUID.randomUUID().toString().replace("-", "") + fileExtension;

        try {
            photofile.transferTo(new File(realFolder + "/" + fileName));

        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }

        memberService.updatePhoto(fileName, num);

        return fileName;
    }


    @GetMapping("/member/delete")
    public String delete(
            @RequestParam int num
    ) {
        int isDeleted = memberService.deleteMember(num);

        if (isDeleted == 1) {
            return "redirect:/member/list";
        } else {
            return "redirect:/member/detail?num=" + num;
        }
    }
}
