package com.example.hexagonalarchitecture.order.application.service;

import com.example.hexagonalarchitecture.order.adapter.in.web.dto.CreateOrderRequestDto;
import com.example.hexagonalarchitecture.order.application.port.in.CreateOrderUseCase;
import com.example.hexagonalarchitecture.order.application.port.out.CreateOrderPort;
import com.example.hexagonalarchitecture.order.domain.Order;
import com.example.hexagonalarchitecture.order.shared.mapper.OrderMapper;
import com.example.hexagonalarchitecture.product.application.port.out.FindProductPort;
import com.example.hexagonalarchitecture.product.domain.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CreateOrderService implements CreateOrderUseCase {
    private final CreateOrderPort createOrderPort;
    private final FindProductPort findProductPort;
    private final OrderMapper orderMapper;

    @Override
    public void createOrder(CreateOrderRequestDto dto) {
        Order findOrder = orderMapper.toDomain(dto);
        List<Product> findProducts = findProductPort.findByIdIn(dto.getProductIds());
        createOrderPort.createOrder(findOrder, findProducts);
    }
}
