package com.example.hexagonalarchitecture.order.shared.mapper;

import com.example.hexagonalarchitecture.order.adapter.in.web.dto.CreateOrderRequestDto;
import com.example.hexagonalarchitecture.order.adapter.in.web.dto.TrackOrderResponseDto;
import com.example.hexagonalarchitecture.order.adapter.out.persistence.order.OrderEntity;
import com.example.hexagonalarchitecture.order.domain.Order;
import com.example.hexagonalarchitecture.product.domain.Product;

import java.util.List;

public interface OrderMapper {
    Order toDomain(OrderEntity entity);
    Order toDomain(CreateOrderRequestDto dto);
    OrderEntity toEntity(Order domain);
    TrackOrderResponseDto toDto(Order order, List<Product> products);
}
