package com.example.hexagonalarchitecture.order.application.port.in;

import com.example.hexagonalarchitecture.order.adapter.in.web.dto.OrderResponseDto;

import java.util.List;

public interface TrackOrderUseCase {
    List<OrderResponseDto> trackOrders(long userId);
    OrderResponseDto trackOrder(long userId, long orderId);
    OrderResponseDto trackOrder(String orderNo);
}
