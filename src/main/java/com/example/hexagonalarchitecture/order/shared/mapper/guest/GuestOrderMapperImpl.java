package com.example.hexagonalarchitecture.order.shared.mapper.guest;

import com.example.hexagonalarchitecture.guest.domain.Guest;
import com.example.hexagonalarchitecture.order.domain.guest.GuestOrderCommand;
import com.example.hexagonalarchitecture.product.domain.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GuestOrderMapperImpl implements GuestOrderMapper {
    @Override
    public GuestOrderCommand toDomain(Guest guest, List<Product> products) {
        return GuestOrderCommand.builder()
                .guest(guest)
                .products(products)
                .build();
    }
}
