package day0520.upload.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UploadMulController {
    @GetMapping("/upload-form2")
    public String upload2() {
        return "/upload/upload-form-2";
    }

    @PostMapping("/upload2")
    public String upload2(
            @RequestParam("file") List<MultipartFile> files,
            @RequestParam("title") String title,
            HttpServletRequest request,
            Model model
    ) {
        List<String> fileNameList = new ArrayList<>();
        for (MultipartFile file : files) {
            if (!file.isEmpty()) {
                String fileName = file.getOriginalFilename();
                fileNameList.add(fileName);
            }
        }

        model.addAttribute("title", title);
        model.addAttribute("fileNameList", fileNameList);

        return "/upload/result-photo-2";
    }

}
