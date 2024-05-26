package com.example.hexagonalarchitecture.order.adapter.out.persistence.guest.order;

import com.example.hexagonalarchitecture.order.domain.Order;

import java.util.Optional;

public interface GuestOrderEntityRepository {
    Optional<String> findLastOrderNumber();
    Optional<Order> findOne(String orderNumber);
}
