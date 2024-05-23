package com.example.hexagonalarchitecture.order.adapter.in.web;

import com.example.hexagonalarchitecture.order.adapter.in.web.dto.CreateGuestOrderRequestDto;
import com.example.hexagonalarchitecture.order.adapter.in.web.dto.CreateUserOrderRequestDto;
import com.example.hexagonalarchitecture.order.application.port.in.CreateOrderUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CommandOrderController {
    private final CreateOrderUseCase createOrderUseCase;

    @PostMapping("/api/user/{userId}/order")
    public ResponseEntity<String> createOrder(
            @PathVariable("userId") long userId,
            @RequestBody CreateUserOrderRequestDto dto
    ) {
        createOrderUseCase.createOrder(userId, dto.getProductIds());
        return ResponseEntity.ok("succeed");
    }

    @PostMapping("/api/guest/order")
    public ResponseEntity<String> createOrder(@RequestBody CreateGuestOrderRequestDto dto) {
        createOrderUseCase.createOrder(dto.getCustomerName(), dto.getProductIds());
        return ResponseEntity.ok("succeed");
    }
}
