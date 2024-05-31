package com.example.demo.controller.member;

import com.example.demo.data.dto.MemberDto;
import com.example.demo.data.mapper.MemberMapperInter;
import com.example.demo.data.service.MemberService;
import com.example.demo.naver.cloud.NcpObjectStorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.net.http.HttpRequest;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class MemberFormController {
    private final MemberService memberService;
    private final MemberMapperInter memberMapperInter;
    private final NcpObjectStorageService ncpObjectStorageService;

    private String bucketName = "bitcamp-bucket-56";
    private String flolderName = "photocommon";




    @GetMapping("/member/form")
    public String memberForm() {
        return "member/member-form";
    }

    @PostMapping("/member/idCheck")
    @ResponseBody
    public int idCheck(
            @RequestParam String myid
    ) {
        return memberMapperInter.searchIdCheck(myid);
    }

    @PostMapping("/member/insert")
    public String insertMember(
            @ModelAttribute MemberDto memberDto,
            @RequestParam("photofile") MultipartFile file,
            HttpServletRequest request
    ){
//        String realPath = request.getSession().getServletContext().getRealPath("/upload-img");
//        String originalFilename = file.getOriginalFilename(); //같은 서버에 같은 파일명으로 업로드 하면 덮어쓰기 됨
//        String fileExtension = "";
//        int lastIndex = originalFilename.lastIndexOf(".");
//        if (lastIndex != -1) {
//            fileExtension = originalFilename.substring(lastIndex); // 파일 확장자 가져오기
//        }
//        String fileName = UUID.randomUUID().toString().replace("-", "") + fileExtension;
//
//        try {
//            file.transferTo(new File(realPath + "/" + fileName));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        memberDto.setPhoto(fileName);

        String photo = ncpObjectStorageService.uploadFile(bucketName, flolderName, file);
        memberDto.setPhoto(photo);

        System.out.println(memberDto);

//        memberService.insertMember(memberDto);

        return "redirect:/member/list";
    }



    @GetMapping("/member/update")
    public String updateForm(
            @RequestParam("num") int num,
            Model model
    ) {
        MemberDto dto = memberService.getMemberById(num);

        model.addAttribute("member", dto);

        return "member/member-update";
    }


    @PostMapping("/member/update/form-action")
    public String updateFormAction(
            @ModelAttribute MemberDto member
    ){

        memberService.updateMember(member);


        return "redirect:/member/detail?num=" + member.getNum();
    }
}
