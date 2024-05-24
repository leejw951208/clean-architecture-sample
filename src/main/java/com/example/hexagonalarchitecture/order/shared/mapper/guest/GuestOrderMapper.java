package com.example.hexagonalarchitecture.order.shared.mapper.guest;

import com.example.hexagonalarchitecture.guest.domain.Guest;
import com.example.hexagonalarchitecture.order.domain.guest.GuestOrderCommand;
import com.example.hexagonalarchitecture.product.domain.Product;

import java.util.List;

public interface GuestOrderMapper {
    GuestOrderCommand toDomain(Guest guest, List<Product> products);
}
