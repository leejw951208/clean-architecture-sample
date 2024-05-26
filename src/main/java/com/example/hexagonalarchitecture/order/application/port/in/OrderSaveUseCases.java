package com.example.hexagonalarchitecture.order.application.port.in;

import java.util.List;

public interface OrderSaveUseCases {
    void createOrder(long userId, List<Long> productIds);
    void createOrder(String name, List<Long> productIds);
}
