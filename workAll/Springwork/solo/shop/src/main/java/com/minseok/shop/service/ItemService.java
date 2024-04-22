package com.minseok.shop.service;

import com.minseok.shop.model.Comment;
import com.minseok.shop.model.Item;
import com.minseok.shop.repository.CommentRepository;
import com.minseok.shop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;
    private final CommentRepository commentRepository;

    public void saveItem(String title, Long price,String url, Authentication auth) {
        //제품명이 없거나 가격이 0일 때 db에 저장하지 않고 리턴함
        if (title == null || price == 0) return;

        //사진 등록안했을때 기본 사진 등록
        if (url.equalsIgnoreCase("")) url = "https://placehold.co/300";

        Item item = new Item();
        item.title = title;
        item.price = price;
        item.url = url;

        //로그인을 하지 않았을 경우 등록유지명 지정
        if (auth == null) {
            item.writeUserId = "익명";
        } else {
            item.writeUserId = auth.getName();
        }

        System.out.println(item);
        itemRepository.save(item);
    }

    public void editItem(Long id, String title, Long price, String url, Authentication auth) {
        Optional<Item> result = itemRepository.findById(id);
        if (result.isPresent()) {
            //사진 등록안했을때 기본 사진 등록
            if (url.equalsIgnoreCase("")) url = "https://placehold.co/300";

            Item item = result.get();
            item.url = url;
            item.title = title;
            item.price = price;

            //로그인을 하지 않았을 경우 등록유지명 지정
            if (auth == null) {
                item.writeUserId = "익명";
            } else {
                item.writeUserId = auth.getName();
            }
            itemRepository.save(item);
            System.out.println(item);
        }
    }

    // 제품 페이징 처리
    public Page<Item> getListPage(Integer page_num, Integer size) {
        return itemRepository.findPageBy(PageRequest.of(page_num - 1, size));
    }

    public Page<Item> getSearchPage(@RequestParam String text,
                             @RequestParam(defaultValue = "0") int page,
                             @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return itemRepository.queryFindByPage(text, pageable);
    }

    // 제품 상세 조회
    public Optional<Item> getItem(Long id) {
        return itemRepository.findById(id);
    }

    //제품 상세 페이지 댓글 페이징 처리
    public Page<Comment> getCommentPage(Long id, Integer page_num, Integer size) {
        return commentRepository.findByParentId(id, PageRequest.of(page_num - 1, size));
    }

    //
    public void delComment(Long parentId){
        var parent = commentRepository.findByParentId(parentId);
        if (!parent.isEmpty()) {
            for (Comment comment : parent) {
                commentRepository.deleteById(comment.getId());
            }
        }
    }


}
