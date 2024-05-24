package day0520.upload.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Controller
public class UploadOneController {
    @GetMapping("/upload-form1")
    public String upload1() {
        return "/upload/upload-form-1";
    }

    @PostMapping("/upload1")
    public String uploadFile(
            @RequestParam("file") MultipartFile file,
            @RequestParam("title") String title,
            HttpServletRequest request,
            Model model
    ) {
        String realFolder = request.getSession().getServletContext().getRealPath("/");

        String fileName = file.getOriginalFilename();

        try {
            file.transferTo(new File(realFolder + "/" + fileName));
            model.addAttribute("title", title);
            model.addAttribute("fileName", fileName);
            model.addAttribute("filePath", realFolder + "/" + fileName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return "/upload/result-photo-1";
    }
}
