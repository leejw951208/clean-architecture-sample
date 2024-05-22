package com.example.hexagonalarchitecture.order.application.port.in;

import com.example.hexagonalarchitecture.order.adapter.in.web.dto.CreateGuestOrderRequestDto;
import com.example.hexagonalarchitecture.order.adapter.in.web.dto.CreateUserOrderRequestDto;

public interface CreateOrderUseCase {
    void createOrder(CreateUserOrderRequestDto dto);
    void createOrder(CreateGuestOrderRequestDto dto);
}
