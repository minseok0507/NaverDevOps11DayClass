package com.minseok.shop.item;


import com.minseok.shop.comment.Comment;
import com.minseok.shop.comment.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class ItemController {
    private final ItemRepository itemRepository;
    private final ItemService itemService;
    private final S3Service s3Service;
    private final CommentRepository commentRepository;


    @GetMapping("/list")
    String list(Model model) {
        List<Item> result = itemRepository.findAll();
        model.addAttribute("items", result);
        System.out.println(result.size());

        return "redirect:/list/page/1";
    }

    @GetMapping("/list/page/{page_num}")
    String getListPage(Model model, @PathVariable Integer page_num) {
        Page<Item> result = itemRepository.findPageBy(PageRequest.of(page_num - 1, 5));

        model.addAttribute("items", result);
        model.addAttribute("total_page", result.getTotalPages());

        return "list.html";
    }


    @GetMapping("/write")
    String write(Model model, Authentication auth) {
        String writeUser = null;
        if (auth != null) writeUser = auth.getName();
        model.addAttribute("writeUser", writeUser);
        return "write.html";
    }

    @PostMapping("/add")
    String addPost(String title, Integer price, String url, Authentication auth) {
        itemService.saveItem(title, price, url, auth);

        return "redirect:/list";
    }

    @GetMapping("/detail/{id}")
    String detail(@PathVariable Long id, Model model) {
        Optional<Item> result = itemRepository.findById(id);
        if (result.isPresent()) {
            model.addAttribute("item", result.get());

            List<Comment> comments = commentRepository.findByParentId(result.get().id);
            model.addAttribute("comments", comments);

            return "detail.html";
        }
        return "redirect:/list";
    }

    @GetMapping("/EditItem/{id}")
    String EditItem(@PathVariable Long id, Model model) {
        Optional<Item> result = itemRepository.findById(id);
        if (result.isPresent()) {
            model.addAttribute("items", result.get());

            return "edit.html";
        }
        return "redirect:/list";
    }


    @PostMapping("/edit")
    String editPost(Long id, String title, Integer price, Authentication auth) {
        if (title.length() > 100 || price < 0) {
            return "error";
        }
        itemService.editItem(id, title, price, auth);

        return "redirect:/list";
    }
//
//    @GetMapping("/delItem/{id}")
//    String delItem(@PathVariable Long id) {
//        itemRepository.deleteById(id);
//
//        return "redirect:/list";
//    }

    @DeleteMapping("/item")
    ResponseEntity<String> deleteItem(@RequestParam Long id) {
        itemRepository.deleteById(id);

        return ResponseEntity.status(200).body("삭제함");
    }

    @GetMapping("/presigned-url")
    @ResponseBody
    String getURL(@RequestParam String filename) {
        String result = s3Service.createPreSignedUrl("test/" + filename);
        System.out.println(result);
        return result;
    }





}
