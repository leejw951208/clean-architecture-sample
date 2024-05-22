package com.example.hexagonalarchitecture.order.shared.mapper;

import com.example.hexagonalarchitecture.customer.adapter.out.persistence.customer.CustomerEntity;
import com.example.hexagonalarchitecture.customer.domain.Customer;
import com.example.hexagonalarchitecture.order.adapter.in.web.dto.CreateGuestOrderRequestDto;
import com.example.hexagonalarchitecture.order.adapter.in.web.dto.CreateUserOrderRequestDto;
import com.example.hexagonalarchitecture.order.adapter.in.web.dto.TrackOrderResponseDto;
import com.example.hexagonalarchitecture.order.adapter.out.persistence.order.OrderEntity;
import com.example.hexagonalarchitecture.order.adapter.out.persistence.orderproduct.OrderProductEntity;
import com.example.hexagonalarchitecture.order.domain.CommandOrder;
import com.example.hexagonalarchitecture.order.domain.QueryOrder;
import com.example.hexagonalarchitecture.product.adapter.out.persistence.ProductEntity;
import com.example.hexagonalarchitecture.product.domain.Product;

import java.util.List;

public interface OrderMapper {
    QueryOrder toDomain(CreateUserOrderRequestDto dto);
    QueryOrder toDomain(CreateGuestOrderRequestDto dto);
    CommandOrder toDomain(Customer customer, List<Product> products);
    OrderEntity toEntity(CommandOrder domain, CustomerEntity customerEntity);
    TrackOrderResponseDto toDto(QueryOrder order, List<Product> products);
    List<OrderProductEntity> toEntities(OrderEntity orderEntity, List<ProductEntity> productEntities);
}
