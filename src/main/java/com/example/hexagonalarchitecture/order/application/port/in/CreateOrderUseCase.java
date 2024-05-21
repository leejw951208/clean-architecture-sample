package com.example.hexagonalarchitecture.order.application.port.in;

import com.example.hexagonalarchitecture.order.adapter.in.web.dto.CreateOrderRequestDto;

public interface CreateOrderUseCase {
    void createOrder(CreateOrderRequestDto dto);
}
