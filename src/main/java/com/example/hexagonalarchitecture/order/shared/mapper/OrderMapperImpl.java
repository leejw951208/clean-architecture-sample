package com.example.hexagonalarchitecture.order.shared.mapper;

import com.example.hexagonalarchitecture.order.adapter.in.web.dto.CreateOrderRequestDto;
import com.example.hexagonalarchitecture.order.adapter.in.web.dto.TrackOrderResponseDto;
import com.example.hexagonalarchitecture.order.adapter.out.persistence.order.OrderEntity;
import com.example.hexagonalarchitecture.order.domain.Order;
import com.example.hexagonalarchitecture.product.domain.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderMapperImpl implements OrderMapper {
    @Override
    public Order toDomain(OrderEntity entity) {
        return Order.builder()
                .id(entity.getId())
                .customerName(entity.getCustomerName())
                .orderStatus(entity.getOrderStatus())
                .orderDate(entity.getOrderDate())
                .build();
    }

    @Override
    public Order toDomain(CreateOrderRequestDto dto) {
        return Order.builder()
                .customerName(dto.getCustomerName())
                .orderStatus(1)
                .build();
    }

    @Override
    public OrderEntity toEntity(Order domain) {
        return OrderEntity.builder()
                .customerName(domain.getCustomerName())
                .orderStatus(domain.getOrderStatus())
                .orderDate(domain.getOrderDate())
                .build();
    }

    @Override
    public TrackOrderResponseDto toDto(Order order, List<Product> products) {
        return TrackOrderResponseDto.builder()
                .id(order.getId())
                .customerName(order.getCustomerName())
                .orderStatus(order.getOrderStatus())
                .orderDate(order.getOrderDate())
                .products(products)
                .build();

    }
}
