package member.controller;

import lombok.RequiredArgsConstructor;
import member.dao.CommentDao;
import member.dto.CommentDto;
import member.dto.MemberDto;
import member.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class DetailController {

    private final MemberService memberService;
    private final CommentDao commentDao;

    @GetMapping("/detail")
    public String detail(@RequestParam int num, Model model) {
        MemberDto dto = memberService.findByNum(num);
        List<CommentDto> commentDtoList = commentDao.getCommentsByMemberNum(num);
        System.out.println(commentDtoList.toString());

        model.addAttribute("member", dto);
        model.addAttribute("comments", commentDtoList);
        return "member/member-detail";
    }

    @PostMapping("/photoupdate")
    @ResponseBody
    public String photoUpdate(
            @RequestParam("num") int num,
            @RequestParam("photofile") MultipartFile photofile,
            HttpServletRequest request) {


        String realFolder = request.getSession().getServletContext().getRealPath("/resources");

        String originalFilename = photofile.getOriginalFilename(); //같은 서버에 같은 파일명으로 업로드 하면 덮어쓰기 됨
        String fileExtension = "";
        int lastIndex = originalFilename.lastIndexOf(".");
        if (lastIndex != -1) {
            fileExtension = originalFilename.substring(lastIndex); // 파일 확장자 가져오기
        }
        String fileName = UUID.randomUUID().toString().replace("-", "") + fileExtension;
        System.out.println(realFolder + "/" + fileName);


        try {
            photofile.transferTo(new File(realFolder + "/" + fileName));

        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }

        memberService.updatePhoto(num, fileName);

        return fileName;
    }
}
