package org.example.bootjpaex1.controller;

import lombok.RequiredArgsConstructor;
import org.example.bootjpaex1.cloud.NcpObjectStorageService;
import org.example.bootjpaex1.data.MycarDto;
import org.example.bootjpaex1.repository.MyCarRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MycarController {
    private final MyCarRepository myCarRepository;
    private final NcpObjectStorageService ncpObjectStorageService;

    private final String bucket = "bit-study";
    private final String folder = "ex1";


    @GetMapping("/")
    public String home() {
        return "redirect:/mycar/list";
    }

    @GetMapping("/mycar/list")
    public String carList(
            Model model
    ) {
        List<MycarDto> mycarDtoList = myCarRepository.findAll();
        model.addAttribute("mycarDtoList", mycarDtoList);
        return "mycar/list";
    }

    @GetMapping("/mycar/form")
    public String carForm() {
        return "mycar/form";
    }

    @PostMapping("/mycar/insert")
    public String insert(
            MycarDto mycarDto,
            @RequestParam("photo_file") MultipartFile photo_file
            ) {
        System.out.println(mycarDto);
        mycarDto.setPhoto(ncpObjectStorageService.uploadFile(bucket, folder, photo_file));
        myCarRepository.save(mycarDto);
        return "redirect:/mycar/list";
    }
}
