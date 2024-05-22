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
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderMapperImpl implements OrderMapper {
    @Override
    public QueryOrder toDomain(CreateUserOrderRequestDto dto) {
        return QueryOrder.builder()
                .orderStatus(1)
                .build();
    }

    @Override
    public QueryOrder toDomain(CreateGuestOrderRequestDto dto) {
        return QueryOrder.builder()
                .orderStatus(1)
                .build();
    }

    @Override
    public CommandOrder toDomain(Customer customer, List<Product> products) {
        return CommandOrder.builder()
                .customer(customer)
                .products(products)
                .build();
    }

    @Override
    public OrderEntity toEntity(CommandOrder domain, CustomerEntity customerEntity) {
        return OrderEntity.builder()
                .customerEntity(customerEntity)
                .orderStatus(1)
                .build();
    }

    @Override
    public TrackOrderResponseDto toDto(QueryOrder order, List<Product> products) {
        return TrackOrderResponseDto.builder()
                .id(order.getId())
                .customerName(order.getCustomerName())
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
}
