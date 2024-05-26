package com.example.hexagonalarchitecture.order.adapter.out.persistence.user.order;

import com.example.hexagonalarchitecture.order.domain.Order;

import java.util.Optional;

public interface UserOrderEntityRepository {
    Optional<String> findLastOrderNumber();
    Optional<Order> findByOrderId(long orderId);
}
