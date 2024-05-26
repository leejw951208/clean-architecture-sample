package com.example.hexagonalarchitecture.order.application.port.in;

import com.example.hexagonalarchitecture.order.domain.Order;

public interface OrderFindUseCases {
    Order findOrder(long orderId);
    Order findOrder(String orderNumber);
}
