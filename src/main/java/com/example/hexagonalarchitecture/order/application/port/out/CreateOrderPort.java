package com.example.hexagonalarchitecture.order.application.port.out;

import com.example.hexagonalarchitecture.order.domain.Order;

public interface CreateOrderPort {
    void createOrder(Order domain);
}
