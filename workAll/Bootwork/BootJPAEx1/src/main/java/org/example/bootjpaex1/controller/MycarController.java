package org.example.bootjpaex1.controller;

import lombok.RequiredArgsConstructor;
import org.example.bootjpaex1.cloud.NcpObjectStorageService;
import org.example.bootjpaex1.data.MycarDto;
import org.example.bootjpaex1.repository.MyCarRepository;
import org.example.bootjpaex1.service.MycarService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class MycarController {
    private final MyCarRepository myCarRepository;
    private final NcpObjectStorageService ncpObjectStorageService;
    private final MycarService mycarService;

    private final String bucket = "bit-study";
    private final String folder = "ex1";


    @GetMapping("/")
    public String home() {
        return "redirect:/mycar/list";
    }

    @GetMapping("/mycar/list")
    public String carList(
            @RequestParam(value = "more", defaultValue = "0") Integer more,
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            Model model
    ) {
        int pageSize = 0;
        if (more == 0) {
            pageSize = 3;
        } else {
            pageSize += more;
        }

        Pageable pageable = PageRequest.of(page, pageSize, Sort.by(Sort.Direction.ASC, "id"));
        System.out.println("pageable: " + pageable);

        Page<MycarDto> result = myCarRepository.findAll(pageable);
        System.out.println("result: " + result);

        model.addAttribute("mycarDtoList", result);
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


    @GetMapping("/mycar/detail")
    public String detail(
            @RequestParam("id") Long id,
            Model model
    ) {
        Optional<MycarDto> Dto = myCarRepository.findById(id);

        model.addAttribute("mycarDto", Dto.get());

        return "mycar/detail";
    }

    @GetMapping("/mycar/update")
    public String update(
            @RequestParam("id") Long id,
            Model model
    ) {
        Optional<MycarDto> Dto = myCarRepository.findById(id);
        model.addAttribute("mycarDto", Dto.get());
        return "mycar/updateform";
    }


    @PostMapping("/mycar/update")
    public String update(
            MycarDto mycarDto,
            @RequestParam(required = false, value = "photo_file") MultipartFile photo_file
    ) {
        if (!photo_file.isEmpty()) {
            var oldPhoto = myCarRepository.findById(mycarDto.getId()).get().getPhoto();
            ncpObjectStorageService.deleteFile(bucket, folder, oldPhoto);
            mycarDto.setPhoto(ncpObjectStorageService.uploadFile(bucket, folder, photo_file));
        } else {
            mycarDto.setPhoto("no");
        }
        System.out.println(mycarDto);
        mycarService.updateCar(mycarDto);
        return "redirect:/mycar/detail?id=" + mycarDto.getId();
    }

    @DeleteMapping("/mycar/delete")
    public String delete(
            @RequestParam("id") Long id
    ) {
        var oldPhoto = myCarRepository.findById(id).get().getPhoto();
        ncpObjectStorageService.deleteFile(bucket, folder, oldPhoto);
        myCarRepository.deleteById(id);
        return "redirect:/";
    }

}
