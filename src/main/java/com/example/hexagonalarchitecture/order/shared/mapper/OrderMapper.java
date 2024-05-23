package com.example.hexagonalarchitecture.order.shared.mapper;

import com.example.hexagonalarchitecture.order.adapter.out.persistence.customer.CustomerEntity;
import com.example.hexagonalarchitecture.order.adapter.in.web.dto.CreateGuestOrderRequestDto;
import com.example.hexagonalarchitecture.order.adapter.in.web.dto.CreateUserOrderRequestDto;
import com.example.hexagonalarchitecture.order.adapter.in.web.dto.OrderResponseDto;
import com.example.hexagonalarchitecture.order.adapter.out.persistence.order.OrderEntity;
import com.example.hexagonalarchitecture.order.adapter.out.persistence.orderproduct.OrderProductEntity;
import com.example.hexagonalarchitecture.order.domain.Order;
import com.example.hexagonalarchitecture.product.adapter.out.persistence.ProductEntity;
import com.example.hexagonalarchitecture.product.domain.Product;

import java.util.List;

public interface OrderMapper {
    Order toDomain(CreateUserOrderRequestDto dto);
    Order toDomain(CreateGuestOrderRequestDto dto);
    OrderEntity toEntity(CustomerEntity customerEntity);
    OrderResponseDto toDto(Order order, List<Product> products);
    List<OrderProductEntity> toEntities(OrderEntity orderEntity, List<ProductEntity> productEntities);
    List<OrderResponseDto> toDtos(List<Order> orders);
}
