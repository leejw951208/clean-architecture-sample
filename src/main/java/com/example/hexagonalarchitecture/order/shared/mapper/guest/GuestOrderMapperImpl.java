package com.example.hexagonalarchitecture.order.shared.mapper.guest;

import com.example.hexagonalarchitecture.guest.adapter.out.persistence.GuestEntity;
import com.example.hexagonalarchitecture.guest.domain.Guest;
import com.example.hexagonalarchitecture.order.adapter.out.persistence.guest.detail.GuestOrderDetailEntity;
import com.example.hexagonalarchitecture.order.adapter.out.persistence.guest.order.GuestOrderEntity;
import com.example.hexagonalarchitecture.order.domain.guest.GuestOrderCommand;
import com.example.hexagonalarchitecture.product.adapter.out.persistence.ProductEntity;
import com.example.hexagonalarchitecture.product.domain.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GuestOrderMapperImpl implements GuestOrderMapper {
    @Override
    public GuestOrderCommand toDomain(Guest guest, String orderNumber, List<Product> products) {
        return GuestOrderCommand.builder()
                .guest(guest)
                .orderNumber(orderNumber)
                .products(products)
                .build();
    }

    @Override
    public GuestOrderEntity toEntity(GuestEntity guest, String orderNumber) {
        return GuestOrderEntity.builder()
                .guest(guest)
                .orderNumber(orderNumber)
                .postNumber("12345")
                .address("테스트")
                .addressDetail("입니다.")
                .build();
    }

    @Override
    public List<GuestOrderDetailEntity> toEntity(GuestOrderEntity guestOrder, List<ProductEntity> products) {
        return products.stream()
                .map(product -> GuestOrderDetailEntity.builder()
                        .guestOrder(guestOrder)
                        .product(product)
                        .orderStatus(1)
                        .build()
                )
                .toList();
    }
}
