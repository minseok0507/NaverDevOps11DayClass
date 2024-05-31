package com.example.demo.controller.guest;

import com.example.demo.data.dto.GuestDto;
import com.example.demo.data.dto.GuestPhotoDto;
import com.example.demo.data.service.GuestService;
import com.example.demo.data.service.MemberService;
import com.example.demo.naver.cloud.NcpObjectStorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/guest")
@RequiredArgsConstructor
public class GuestAjaxController {
    private final GuestService guestService;
    private final NcpObjectStorageService ncpObjectStorageService;

    private String bucketName = "bitcamp-buchet-56";
    private String folderName = "guestphoto";

    @PostMapping("/addguest")
    public void guestInsert(
            @RequestParam("gcontent") String gcontent,
            @RequestParam("uploadFiles") List<MultipartFile> uploadFiles,
            HttpServletRequest request
    ) {
        HttpSession session = request.getSession();
        String myid = (String) session.getAttribute("myid");
        String writer = "민석잉";
        GuestDto dto = GuestDto.builder()
                .writer(writer)
                .myid(myid)
                .gcontent(gcontent)
                .build();
        guestService.insertGuest(dto);
        int guestidx = dto.getGuestidx();
        if (uploadFiles == null) {
            return;
        }
        for (MultipartFile file : uploadFiles) {
            String photoname = ncpObjectStorageService.uploadFile(bucketName, folderName, file);
            GuestPhotoDto.builder()
                    .guestidx(guestidx)
                    .photoname(photoname)
                    .build();
        }
    }
}
