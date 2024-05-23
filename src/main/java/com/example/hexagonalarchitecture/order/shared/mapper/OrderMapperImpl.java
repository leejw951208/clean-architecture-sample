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
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class OrderMapperImpl implements OrderMapper {
    @Override
    public Order toDomain(CreateUserOrderRequestDto dto) {
        return Order.builder()
                .orderStatus(1)
                .build();
    }

    @Override
    public Order toDomain(CreateGuestOrderRequestDto dto) {
        return Order.builder()
                .orderStatus(1)
                .build();
    }

    @Override
    public OrderEntity toEntity(CustomerEntity customerEntity) {
        return OrderEntity.builder()
                .customerEntity(customerEntity)
                .orderNo(UUID.randomUUID().toString())
                .orderStatus(1)
                .build();
    }

    @Override
    public OrderResponseDto toDto(Order order, List<Product> products) {
        return OrderResponseDto.builder()
                .id(order.getId())
                .customerName(order.getCustomerName())
                .orderNo(order.getOrderNo())
                .orderStatus(order.getOrderStatus())
                .orderDate(order.getOrderDate())
                .products(products)
                .build();

    }

    @Override
    public List<OrderProductEntity> toEntities(OrderEntity orderEntity, List<ProductEntity> productEntities) {
        return productEntities.stream()
                .map(productEntity -> OrderProductEntity.builder()
                        .orderEntity(orderEntity)
                        .productEntity(productEntity)
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public List<OrderResponseDto> toDtos(List<Order> orders) {
        return orders.stream()
                .map(order -> OrderResponseDto.builder()
                        .id(order.getId())
                        .customerName(order.getCustomerName())
                        .orderNo(order.getOrderNo())
                        .orderStatus(order.getOrderStatus())
                        .orderDate(order.getOrderDate())
                        .products(order.getProducts())
                        .build()
                )
                .toList();
    }
}
