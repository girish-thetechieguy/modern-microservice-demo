package com.techstarter.orderservice.service;

import com.techstarter.orderservice.dto.InventoryResponse;
import com.techstarter.orderservice.dto.OrderLineItemDto;
import com.techstarter.orderservice.dto.OrderRequest;
import com.techstarter.orderservice.model.Order;
import com.techstarter.orderservice.model.OrderLineItem;
import com.techstarter.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;
    private final WebClient webClient;
    public void placeOrder(OrderRequest orderRequest){
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        List<OrderLineItem> orderLineItemList = orderRequest.getOrderLineItemDtos()
                .stream()
                .map(this::mapToDto)
                .toList();
        order.setOrderLineItemList(orderLineItemList);
        List<String> skuCodes = order.getOrderLineItemList().stream().map(OrderLineItem::getSkuCode)
                .toList();
        InventoryResponse[] inventoryResponses = webClient.get()
                .uri("http://localhost:8083/api/inventory",
                        uriBuilder -> uriBuilder.queryParam("skuCode", skuCodes).build())
                .retrieve()
                        .bodyToMono(InventoryResponse[].class)
                                .block();
        boolean allproductsInStock = Arrays.stream(inventoryResponses).allMatch(InventoryResponse::isInstock);
        if(allproductsInStock)
            orderRepository.save(order);
        else
            throw new IllegalArgumentException("Product is not in stock! Please check");
    }

    private OrderLineItem mapToDto(OrderLineItemDto orderLineItemDto) {
        OrderLineItem orderLineItem = new OrderLineItem();
        orderLineItem.setPrice(orderLineItemDto.getPrice());
        orderLineItem.setQuantity(orderLineItemDto.getQuantity());
        orderLineItem.setSkuCode(orderLineItemDto.getSkuCode());
        return orderLineItem;
    }
}
