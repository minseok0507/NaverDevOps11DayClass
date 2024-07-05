package org.example.bootjpaex1.controller;

import lombok.RequiredArgsConstructor;
import org.example.bootjpaex1.data.MyCarCommentDto;
import org.example.bootjpaex1.data.MycarDto;
import org.example.bootjpaex1.repository.MyCarCommentRepository;
import org.example.bootjpaex1.service.MyCarCommentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RestController
public class MyCarCommentController {
    private final MyCarCommentService myCarCommentService;
    private final MyCarCommentRepository commentRepository;

    @PostMapping("/addcomment")
    public void addComment(
            @RequestParam("mycarId") Long mycarId,
            @RequestParam("comment") String comment
    ) {
        var commentDto = MyCarCommentDto.builder()
                .comment(comment)
                .mycarDto(MycarDto.builder().id(mycarId).build())
                .build();
        commentRepository.save(commentDto);
    }

    @GetMapping("/comment")
    public List<MyCarCommentDto> getComments(
            @RequestParam("mycarId") Long mycarId,
            @RequestParam(defaultValue = "0", value = "page") Integer page
    ) {
        return commentRepository.findByCarId(mycarId);
    }

    @DeleteMapping("/comment")
    public void deleteComment(
            @RequestParam("id")Long id
    ){
        commentRepository.deleteById(id);
    }
}
