package com.minseok.shop.item;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public void saveItem(String title, Integer price,String url, Authentication auth) {
        //제품명이 없거나 가격이 0일 때 db에 저장하지 않고 리턴함
        if (title == null || price == 0) return;

        //사진 등록안했을때 기본 사진 등록
        if (url == null) url = "https://placehold.co/300";

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

    public void editItem(Long id, String title, Integer price, Authentication auth) {
        Optional<Item> result = itemRepository.findById(id);
        if (result.isPresent()) {
            Item item = result.get();

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

}
