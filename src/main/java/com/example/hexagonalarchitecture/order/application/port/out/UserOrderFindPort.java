package com.example.hexagonalarchitecture.order.application.port.out;

import com.example.hexagonalarchitecture.order.domain.Order;

public interface UserOrderFindPort {
    String findLastOrderNumber();
    Order findByOrderId(long orderId);
}
