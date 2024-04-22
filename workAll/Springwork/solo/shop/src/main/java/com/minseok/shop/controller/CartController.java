package com.minseok.shop.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.minseok.shop.model.*;
import com.minseok.shop.repository.*;
import com.minseok.shop.service.ItemService;
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
    private final OrdersRepository ordersRepository;
    private final OrderNewRepository orderNewRepository;

    @PostMapping("/item")
    ResponseEntity<String> addCart(@RequestParam Long id,
                                   Authentication auth) {
        // 사용자 찾기
        var userOptional = memberRepository.findByUsername(auth.getName());
        if (userOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("사용자를 찾을 수 없습니다.");
        }
        var userId = userOptional.get().id;


        // 장바구니 아이템 찾기, 없다면 생성
        var cartItemId = cartItemRepository.findByUserId(userId, id);
        CartItem cartItem;
        if (cartItemId.isEmpty()){
            cartItem = new CartItem();
            cartItem.setUserId(userId);
            cartItem.setItemId(id);
            cartItem.setQuantity(1);
            cartItemRepository.save(cartItem);
        } else {
            // 아이템이 이미 장바구니에 있으면, 수량 증가
            cartItem = cartItemId.get();
            cartItem.setQuantity(cartItem.getQuantity()+1);
            cartItemRepository.save(cartItem); //변경된 수량 저장
        }


        return ResponseEntity.ok("장바구니 추가함");
    }

    @PostMapping("/newOrder")
    String addOrder(Long itemId,
                    Integer quantity,
                    Authentication auth) {
        // 사용자 찾기
        var userOptional = memberRepository.findByUsername(auth.getName());
        if (userOptional.isEmpty()) {
            return "redirect://detail/" + itemId;
        }
        var userId = userOptional.get().id;

        OrderNew orderNew = new OrderNew();
        orderNew.setQuantity(quantity);
        Member member = new Member();
        member.setId(userId);
        orderNew.setMember(member);
        Item item = new Item();
        item.setId(itemId);
        orderNew.setItem(item);

        orderNewRepository.save(orderNew);



        return "pay.html";
    }

    @GetMapping("/orderAll")
    String orderAll(Model model, Authentication auth) {
        if (!auth.getName().equals("admin")) {
            return "redirect:/";
        }
        var orderDtoList = new ArrayList<>();

        var resultAll = orderNewRepository.findAll();
        for (int i = 0; i < resultAll.size(); i++) {
            OrderDto orderDto = new OrderDto();
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

    //장바구니
    @GetMapping("/cart")
    public String cart(Model model, Authentication auth) {
        var findMember = memberRepository.findByUsername(auth.getName())
                .orElseThrow(() -> new UsernameNotFoundException("사용자를 찾을 수 없습니다."));
        var userId = findMember.getId();
        var cartItems = cartItemRepository.findAllByUserId(userId);

        // 아이템 ID 수집
        List<Long> itemIds = cartItems.stream()
                .map(CartItem::getItemId)
                .collect(Collectors.toList());

        // 단일 쿼리로 모든 아이템 조회
        List<Item> items = itemRepository.findByIdIn(itemIds);

        // 아이템 ID를 기준으로 Map 생성
        Map<Long, Item> itemMap = items.stream()
                .collect(Collectors.toMap(Item::getId, item -> item));

        // CartDto 리스트 생성
        List<CartDto> cartDtoList = cartItems.stream()
                .map(cartItem -> new CartDto(cartItem, itemMap.get(cartItem.getItemId())))
                .collect(Collectors.toList());

        model.addAttribute("items", cartDtoList);

        return "cart.html";
    }

    //카트 제품 수정 엑션
    @PostMapping("/cart/changeQuantity")
    String cartEdit(@RequestParam Long id, @RequestParam Integer quantity) {
        System.out.println(quantity);
        var result =cartItemRepository.findById(id)
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

    //주문 처리
    @PostMapping("/order")
    String order(@RequestParam("arrayOrderData") String arrayDataJson, Authentication auth) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Long> orderIdList = objectMapper.readValue(arrayDataJson, new TypeReference<>() {});

        var orderList = cartItemRepository.findAllById(orderIdList);
        var findUser = (CustomUser) (auth.getPrincipal());
        List<Orders> ordersToSave = new ArrayList<>();

        // 한 번의 쿼리로 모든 아이템 가격 정보를 조회
        List<Item> items = itemRepository.findAllById(orderList.stream().map(CartItem::getItemId).collect(Collectors.toList()));
        Map<Long, Long> itemIdToPriceMap = items.stream().collect(Collectors.toMap(Item::getId, Item::getPrice));

        for (CartItem cartItem : orderList) {
            Orders orders = new Orders();
            orders.setUserId(findUser.id);
            orders.setItemId(cartItem.getItemId());
            // Map 에서 아이템 가격 정보를 조회
            var findPrice = itemIdToPriceMap.get(cartItem.getItemId());
            orders.setItemPrice(findPrice);
            orders.setQuantity(cartItem.getQuantity());
            orders.setOrderStatus("주문 접수 중");
            ordersToSave.add(orders);
        }

        ordersRepository.saveAll(ordersToSave);

        return "pay.html";
    }

    @GetMapping("/myorder")
    String orderList(Model model, Authentication auth) {
        if (!auth.getName().equals("admin")) {
            return "redirect:/";
        }

        List<Orders> orders = ordersRepository.findAll();
        Map<Long, Item> itemMap = itemRepository.findAllById(orders.stream()
                        .map(Orders::getItemId)
                        .collect(Collectors.toList()))
                .stream()
                .collect(Collectors.toMap(Item::getId, Function.identity()));
        Map<Long, Member> memberMap = memberRepository.findAllById(orders.stream()
                        .map(Orders::getUserId)
                        .collect(Collectors.toList()))
                .stream()
                .collect(Collectors.toMap(Member::getId, Function.identity()));

        List<OrderDto> orderDtoList = orders.stream()
                .map(order -> {
                    OrderDto orderDto = new OrderDto();
                    orderDto.setOrderId(order.getId());
                    orderDto.setItemTitle(itemMap.get(order.getItemId()).getTitle());
                    orderDto.setUserName(memberMap.get(order.getUserId()).getUsername());
                    orderDto.setQuantity(order.getQuantity());
                    orderDto.setOrderDate(order.getOrderDate());
                    orderDto.setOrderStatus(order.getOrderStatus());
                    return orderDto;
                })
                .collect(Collectors.toList());

        model.addAttribute("orderDtoList", orderDtoList);
        return "admin-order-list.html";
    }







}
