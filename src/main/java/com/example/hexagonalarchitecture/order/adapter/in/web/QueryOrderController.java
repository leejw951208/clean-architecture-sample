package com.example.hexagonalarchitecture.order.adapter.in.web;

import com.example.hexagonalarchitecture.order.application.port.in.TrackOrderUseCase;
import com.example.hexagonalarchitecture.order.adapter.in.web.dto.OrderResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class QueryOrderController {
    private final TrackOrderUseCase trackOrderUseCase;

    @GetMapping("/api/user/{userId}/orders")
    public ResponseEntity<List<OrderResponseDto>> findOrders(@PathVariable("userId") long userId) {
        return ResponseEntity.ok(trackOrderUseCase.trackOrders(userId));
    }

    @GetMapping("/api/user/{userId}/order/{orderId}")
    public ResponseEntity<OrderResponseDto> findOrder(@PathVariable("userId") long userId, @PathVariable("orderId") long orderId) {
        return ResponseEntity.ok(trackOrderUseCase.trackOrder(userId, orderId));
    }

    @GetMapping("/api/guest/order/{orderNo}")
    public ResponseEntity<OrderResponseDto> findOrder(@PathVariable("orderNo") String orderNo) {
        return ResponseEntity.ok(trackOrderUseCase.trackOrder(orderNo));
    }
}
