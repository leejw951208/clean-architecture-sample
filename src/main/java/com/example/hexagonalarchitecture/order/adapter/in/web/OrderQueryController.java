package com.example.hexagonalarchitecture.order.adapter.in.web;

import com.example.hexagonalarchitecture.order.application.port.in.OrderFindUseCases;
import com.example.hexagonalarchitecture.order.domain.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderQueryController {
    private final OrderFindUseCases orderFindUseCases;

    @GetMapping("/api/order/{id}")
    public ResponseEntity<Order> findOrder(@PathVariable("id") long id) {
        return ResponseEntity.ok(orderFindUseCases.findOrder(id));
    }

    @GetMapping("/api/order/{orderNumber}")
    public ResponseEntity<Order> findOrder(@PathVariable("orderNumber") String orderNumber) {
        return ResponseEntity.ok(orderFindUseCases.findOrder(orderNumber));
    }
}
