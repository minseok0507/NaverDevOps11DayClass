package com.minseok.shop.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.minseok.shop.model.*;
import com.minseok.shop.repository.*;
import com.minseok.shop.service.ItemService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class CartController {
    private final ItemRepository itemRepository;
    private final MemberRepository memberRepository;
    private final CartItemRepository cartItemRepository;
    private final OrderNewRepository orderNewRepository;


    //장바구니 추가
    @PostMapping("/detailCart")
    String detailAddCart(Long itemId, Integer quantity, Authentication auth) {
        Member user = memberRepository.findByUsername(auth.getName()).orElseThrow(() -> new RuntimeException("User not found"));
        Item item = itemRepository.findById(itemId).orElseThrow(() -> new RuntimeException("Item not found"));

        int updatedRows = cartItemRepository.updateQuantityForUserAndItem(user.getId(), itemId, quantity);

        if (updatedRows == 0) {
            CartItem newCartItem = new CartItem();
            newCartItem.setMember(user);
            newCartItem.setItem(item);
            newCartItem.setQuantity(quantity);
            cartItemRepository.save(newCartItem);
        }

        return "redirect:/detail/" + itemId;
    }


    //장바구니
    @GetMapping("/cart")
    public String cart(Model model, Authentication auth) {
//        var findMember = memberRepository.findByUsername(auth.getName())
//                .orElseThrow(() -> new UsernameNotFoundException("사용자를 찾을 수 없습니다."));
//        var userId = findMember.getId();
//        var cartItems = cartItemRepository.findAllByUserId(userId);


        //
//        // 아이템 ID 수집
//        List<Long> itemIds = cartItems.stream()
//                .map(CartItem::getItemId)
//                .collect(Collectors.toList());
//
//        // 단일 쿼리로 모든 아이템 조회
//        List<Item> items = itemRepository.findByIdIn(itemIds);
//
//        // 아이템 ID를 기준으로 Map 생성
//        Map<Long, Item> itemMap = items.stream()
//                .collect(Collectors.toMap(Item::getId, item -> item));
//
//        // CartDto 리스트 생성
//        List<CartDto> cartDtoList = cartItems.stream()
//                .map(cartItem -> new CartDto(cartItem, itemMap.get(cartItem.getItemId())))
//                .collect(Collectors.toList());

//        model.addAttribute("items", cartDtoList);

        return "cart.html";
    }

    //카트 제품 수정 엑션
    @PostMapping("/cart/changeQuantity")
    String cartEdit(@RequestParam Long id, @RequestParam Integer quantity) {
        System.out.println(quantity);
        var result = cartItemRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("아이템을 찾을 수 없습니다."));
        result.setQuantity(quantity);
        cartItemRepository.save(result);


        return "redirect:/cart";
    }


    //카드 제품 삭제 엑션
    @DeleteMapping("/cart")
    ResponseEntity<String> cartDel(@RequestParam Long id) {
        //카트 지우기
        cartItemRepository.deleteById(id);

        return ResponseEntity.status(200).body("삭제함");
    }

    //카트 안 선택 제품 삭제
    @PostMapping("/cart/selectedDel")
    String selectedDel(@RequestParam("arrayData") String arrayDataJson) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Long> arrayData = objectMapper.readValue(arrayDataJson, new TypeReference<>() {
        });

        //선택된 항목 삭제
        cartItemRepository.deleteAllById(arrayData);

        return "redirect:/cart";
    }


    @GetMapping("/orderAll")
    String orderAll(Model model, Authentication auth) {
        if (!auth.getName().equals("admin")) {
            return "redirect:/";
        }
        var orderDtoList = new ArrayList<>();

        var resultAll = orderNewRepository.findAllWithMemberAndItem();
        for (int i = 0; i < resultAll.size(); i++) {
            OrderDto orderDto = new OrderDto();
            orderDto.setOrderId(resultAll.get(i).getId());
            orderDto.setItemId(resultAll.get(i).getItem().getId());
            orderDto.setItemTitle(resultAll.get(i).getItem().getTitle());
            orderDto.setUserName(resultAll.get(i).getMember().getUsername());
            orderDto.setQuantity(resultAll.get(i).getQuantity());
            orderDto.setOrderDate(resultAll.get(i).getOrderDate());
            orderDto.setOrderStatus(resultAll.get(i).getOrderStatus());
            orderDtoList.add(orderDto);
        }

        model.addAttribute("orderDtoList", orderDtoList);
        return "admin-order-list.html";
    }


}
