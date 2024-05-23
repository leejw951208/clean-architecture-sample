package com.example.hexagonalarchitecture.order.application.port.in;

import com.example.hexagonalarchitecture.order.adapter.in.web.dto.CreateGuestOrderRequestDto;
import com.example.hexagonalarchitecture.order.adapter.in.web.dto.CreateUserOrderRequestDto;

import java.util.List;

public interface CreateOrderUseCase {
    void createOrder(long userId, List<Long> productIds);
    void createOrder(String customerName, List<Long> productIds);
}
