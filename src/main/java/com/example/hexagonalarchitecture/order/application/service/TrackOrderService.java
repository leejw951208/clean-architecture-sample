package com.example.hexagonalarchitecture.order.application.service;

import com.example.hexagonalarchitecture.order.adapter.in.web.dto.TrackOrderResponseDto;
import com.example.hexagonalarchitecture.order.application.port.out.FindOrderPort;
import com.example.hexagonalarchitecture.order.application.port.in.TrackOrderUseCase;
import com.example.hexagonalarchitecture.order.domain.Order;
import com.example.hexagonalarchitecture.order.shared.mapper.OrderMapper;
import com.example.hexagonalarchitecture.product.domain.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TrackOrderService implements TrackOrderUseCase {
    private final FindOrderPort findOrderOutPort;
    private final OrderMapper orderMapper;

    @Override
    public TrackOrderResponseDto trackOrder(Long id) {
        Order findOrder = findOrderOutPort.findById(id);
        List<Product> findProducts = findOrderOutPort.findProductByOrderId(id);
        return orderMapper.toDto(findOrder, findProducts);
    }
}
