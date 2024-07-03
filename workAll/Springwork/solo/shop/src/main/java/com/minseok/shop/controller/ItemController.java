package com.minseok.shop.controller;


import com.minseok.shop.model.*;
import com.minseok.shop.repository.CartItemRepository;
import com.minseok.shop.repository.ItemRepository;
import com.minseok.shop.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.*;

@Controller
@RequiredArgsConstructor
public class ItemController {
    private final ItemRepository itemRepository;
    private final ItemService itemService;
    private final CartItemRepository cartItemRepository;
//    private final S3Service s3Service;


    // 아이템 리스트 조회
    @GetMapping("/list")
    String list() {
        return "redirect:/list/1";
    }
    @PostMapping("/list")
    String postList() {
        return "redirect:/list/1";
    }



    @GetMapping("/list/{page_num}")
    String getListPage(Model model, @PathVariable Integer page_num) {
        //페이지 5개씩 나누기
        Page<Item> result = itemService.getListPage(page_num, 5);

        //페이지 오버시
        if (result.getTotalPages() < page_num) {
            return "redirect:/list/" + result.getTotalPages();
        }


        model.addAttribute("items", result);
        model.addAttribute("total_page", result.getTotalPages());

        return "list.html";
    }


    @PostMapping("/search")
    public String postSearch(@RequestParam String searchText) throws UnsupportedEncodingException {
        String encodeSearchText = URLEncoder.encode(searchText, StandardCharsets.UTF_8);
        System.out.println(encodeSearchText);


        return "redirect:/search/result?search=" + encodeSearchText;
    }

    @GetMapping("/search/result")
    public String search(@RequestParam(value = "search", defaultValue = "") String searchText,
                         @RequestParam(defaultValue = "1") int page_num,
                         Model model) throws UnsupportedEncodingException {

        Pageable pageable = PageRequest.of(page_num - 1, 3); // 페이지당 10개씩 결과를 보여줍니다.
        var result = itemRepository.queryFindByPage(searchText, pageable);

        model.addAttribute("search_text", searchText);
        model.addAttribute("items", result); // 현재 페이지의 아이템을 전달합니다.
        model.addAttribute("total_page", result.getTotalPages()); // 전체 페이지 수를 전달합니다.
        model.addAttribute("page_num", page_num);
        return "search-list.html"; // 검색 결과를 보여주는 템플릿으로 이동합니다.
    }


    //제품 추가 페이지
    @GetMapping("/write")
    String write(Model model, Authentication auth) {
        String writeUser = null;
        if (auth != null) writeUser = auth.getName();
        model.addAttribute("writeUser", writeUser);
        return "write.html";
    }

    //제품 추가 엑션
    @PostMapping("/add")
    String addPost(String title, Long price, String url, Authentication auth) {
        itemService.saveItem(title, price, url, auth);

        return "redirect:/list";
    }

    //제품 상세 페이지
    @GetMapping("/detail/{id}")
    String detailComment(@PathVariable Long id,
                         @RequestParam(value = "comment", defaultValue = "1") Integer page_num,
                         Model model) {
        Optional<Item> result = itemService.getItem(id);
        Page<Comment> commentsPage = itemService.getCommentPage(id, page_num, 9);

        if (result.isPresent()) {
            model.addAttribute("item", result.get());
            model.addAttribute("comments", commentsPage);
            model.addAttribute("page_num", page_num);
            model.addAttribute("total_page", commentsPage.getTotalPages());

            return "detail.html";
        }
        if (commentsPage.getTotalPages() < page_num) {
            return "/detail/" + id;
        }
        return "redirect:/list";
    }

    //제품 수정 페이지
    @GetMapping("/EditItem/{id}")
    String EditItem(@PathVariable Long id, Model model, Authentication auth) {
        //접속 유저 확인 후 유저이름 전달
        String writeUser = null;
        if (auth != null) writeUser = auth.getName();
        model.addAttribute("writeUser", writeUser);

        //아이템정보 조회 후 전달
        var result = itemRepository.findById(id);
        if (result.isPresent()) {
            model.addAttribute("items", result.get());

            return "edit.html";
        }
        return "redirect:/list";
    }

    //제품 수정 엑션
    @PostMapping("/edit")
    String editPost(Long id, String title, Long price, String url, Authentication auth) {
        if (title.length() > 100 || price < 0) {
            return "error";
        }
        itemService.editItem(id, title, price, url, auth);

        return "redirect:/list";
    }

    //제품 삭제 엑션
    @DeleteMapping("/item")
    ResponseEntity<String> deleteItem(@RequestParam Long id) {
        //제품 지우기
        itemRepository.deleteById(id);
        //댓글 지우기
        itemService.delComment(id);
        //카드 등록된 제품 지우기
//        var delCart = cartItemRepository.findAllByItemId(id);
//        for (CartItem cartItem : delCart) {
//            cartItemRepository.deleteById(cartItem.getId());
//        }
        return ResponseEntity.status(200).body("삭제함");
    }


//
//    //aws s3저장
//    @GetMapping("/presigned-url")
//    @ResponseBody
//    String getURL(@RequestParam String filename) {
//        String result = s3Service.createPreSignedUrl("test/" + filename);
//        System.out.println(result);
//        return result;
//    }




}
