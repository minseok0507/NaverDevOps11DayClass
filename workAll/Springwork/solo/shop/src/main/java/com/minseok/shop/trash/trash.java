package com.minseok.shop.trash;

public class trash {
}


/*  orders 클레스 잘못만듦          */
//    //주문 처리
//    @PostMapping("/order")
//    String order(@RequestParam("arrayOrderData") String arrayDataJson, Authentication auth) throws Exception {
//        ObjectMapper objectMapper = new ObjectMapper();
//        List<Long> orderIdList = objectMapper.readValue(arrayDataJson, new TypeReference<>() {});
//
//        var orderList = cartItemRepository.findAllById(orderIdList);
//        var findUser = (CustomUser) (auth.getPrincipal());
//        List<Orders> ordersToSave = new ArrayList<>();
//
//        // 한 번의 쿼리로 모든 아이템 가격 정보를 조회
//        List<Item> items = itemRepository.findAllById(orderList.stream().map(CartItem::getItemId).collect(Collectors.toList()));
//        Map<Long, Long> itemIdToPriceMap = items.stream().collect(Collectors.toMap(Item::getId, Item::getPrice));
//
//        for (CartItem cartItem : orderList) {
//            Orders orders = new Orders();
//            orders.setUserId(findUser.id);
//            orders.setItemId(cartItem.getItemId());
//            // Map 에서 아이템 가격 정보를 조회
//            var findPrice = itemIdToPriceMap.get(cartItem.getItemId());
//            orders.setItemPrice(findPrice);
//            orders.setQuantity(cartItem.getQuantity());
//            orders.setOrderStatus("주문 접수 중");
//            ordersToSave.add(orders);
//        }
//
//        ordersRepository.saveAll(ordersToSave);
//
//        return "pay.html";
//    }
//
//    @GetMapping("/myorder")
//    String orderList(Model model, Authentication auth) {
//        if (!auth.getName().equals("admin")) {
//            return "redirect:/";
//        }
//
//        List<Orders> orders = ordersRepository.findAll();
//        Map<Long, Item> itemMap = itemRepository.findAllById(orders.stream()
//                        .map(Orders::getItemId)
//                        .collect(Collectors.toList()))
//                .stream()
//                .collect(Collectors.toMap(Item::getId, Function.identity()));
//        Map<Long, Member> memberMap = memberRepository.findAllById(orders.stream()
//                        .map(Orders::getUserId)
//                        .collect(Collectors.toList()))
//                .stream()
//                .collect(Collectors.toMap(Member::getId, Function.identity()));
//
//        List<OrderDto> orderDtoList = orders.stream()
//                .map(order -> {
//                    OrderDto orderDto = new OrderDto();
//                    orderDto.setOrderId(order.getId());
//                    orderDto.setItemId(order.getItemId());
//                    orderDto.setItemTitle(itemMap.get(order.getItemId()).getTitle());
//                    orderDto.setUserName(memberMap.get(order.getUserId()).getUsername());
//                    orderDto.setQuantity(order.getQuantity());
//                    orderDto.setOrderDate(order.getOrderDate());
//                    orderDto.setOrderStatus(order.getOrderStatus());
//                    return orderDto;
//                })
//                .collect(Collectors.toList());
//
//        model.addAttribute("orderDtoList", orderDtoList);
//        return "admin-order-list.html";
//    }