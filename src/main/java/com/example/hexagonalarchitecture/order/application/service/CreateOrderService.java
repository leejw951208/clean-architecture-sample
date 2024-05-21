package com.example.hexagonalarchitecture.order.application.service;

import com.example.hexagonalarchitecture.order.adapter.in.web.dto.CreateOrderRequestDto;
import com.example.hexagonalarchitecture.order.application.port.in.CreateOrderUseCase;
import com.example.hexagonalarchitecture.order.application.port.out.CreateOrderPort;
import com.example.hexagonalarchitecture.order.domain.Order;
import com.example.hexagonalarchitecture.order.shared.mapper.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateOrderService implements CreateOrderUseCase {
    private final CreateOrderPort createOrderPort;
    private final OrderMapper orderMapper;

    @Override
    public void createOrder(CreateOrderRequestDto dto) {
        Order domain = orderMapper.toDomain(dto);
        createOrderPort.createOrder(domain);
    }
}
