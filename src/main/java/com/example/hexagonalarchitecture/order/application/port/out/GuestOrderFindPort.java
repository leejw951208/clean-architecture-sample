package com.example.hexagonalarchitecture.order.application.port.out;

import com.example.hexagonalarchitecture.order.domain.Order;

public interface GuestOrderFindPort {
    String findLastOrderNumber();
    Order findByOrderNumber(String orderNumber);
}
