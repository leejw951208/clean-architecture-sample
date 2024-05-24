package com.example.hexagonalarchitecture.order.application.port.in;

import java.util.List;

public interface CreateOrderUseCase {
    void createUserOrder(long userId, List<Long> productIds);
    void createGuestOrder(String name, List<Long> productIds);
}
