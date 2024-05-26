package com.example.hexagonalarchitecture.order.adapter.in.web;

import com.example.hexagonalarchitecture.order.adapter.in.web.dto.GuestOrderSaveDto;
import com.example.hexagonalarchitecture.order.adapter.in.web.dto.OrderUserSaveDto;
import com.example.hexagonalarchitecture.order.application.port.in.OrderSaveUseCases;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderCommandController {
    private final OrderSaveUseCases orderSaveUseCases;

    @PostMapping("/api/user/{userId}/order")
    public ResponseEntity<String> createOrder(
            @PathVariable("userId") long userId,
            @RequestBody OrderUserSaveDto dto
    ) {
        orderSaveUseCases.createOrder(userId, dto.getProductIds());
        return ResponseEntity.ok("succeed");
    }

    @PostMapping("/api/guest/order")
    public ResponseEntity<String> createOrder(@RequestBody GuestOrderSaveDto dto) {
        orderSaveUseCases.createOrder(dto.getCustomerName(), dto.getProductIds());
        return ResponseEntity.ok("succeed");
    }
}
