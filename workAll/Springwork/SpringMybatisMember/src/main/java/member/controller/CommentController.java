package member.controller;

import lombok.RequiredArgsConstructor;
import member.dao.CommentDao;
import member.dto.CommentDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {
    private final CommentDao commentDao;

    @GetMapping("/post")
    @ResponseBody
    public ResponseEntity<List<CommentDto>> getComments(@RequestParam int num) {
        List<CommentDto> comments = commentDao.getCommentsByMemberNum(num);

        return new ResponseEntity<>(comments, HttpStatus.OK);
    }


    @PostMapping("/insert")
    public ResponseEntity<Map<String, Object>> insertComment(@RequestBody CommentDto commentDto) {
        try {
            int commentOk = commentDao.insertComment(commentDto);
            Map<String, Object> response = new HashMap<>();
            response.put("status", "success");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            Map<String, Object> response = new HashMap<>();
            response.put("status", "error");
            response.put("message", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

}
