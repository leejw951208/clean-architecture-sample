package com.example.hexagonalarchitecture.order.adapter.in.web;

import com.example.hexagonalarchitecture.order.adapter.in.web.dto.CreateOrderRequestDto;
import com.example.hexagonalarchitecture.order.application.port.in.CreateOrderUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CommandOrderController {
    private final CreateOrderUseCase createOrderUseCase;

    @PostMapping("/api/order")
    public ResponseEntity<String> createOrder(@RequestBody CreateOrderRequestDto dto) {
        createOrderUseCase.createOrder(dto);
        return ResponseEntity.ok("succeed");
    }
}
