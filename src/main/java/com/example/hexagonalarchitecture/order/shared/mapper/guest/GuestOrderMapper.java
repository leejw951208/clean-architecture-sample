package com.example.hexagonalarchitecture.order.shared.mapper.guest;

import com.example.hexagonalarchitecture.guest.adapter.out.persistence.GuestEntity;
import com.example.hexagonalarchitecture.guest.domain.Guest;
import com.example.hexagonalarchitecture.order.adapter.out.persistence.guest.detail.GuestOrderDetailEntity;
import com.example.hexagonalarchitecture.order.adapter.out.persistence.guest.order.GuestOrderEntity;
import com.example.hexagonalarchitecture.order.domain.GuestOrderSave;
import com.example.hexagonalarchitecture.product.adapter.out.persistence.ProductEntity;
import com.example.hexagonalarchitecture.product.domain.Product;

import java.util.List;

public interface GuestOrderMapper {
    GuestOrderSave fromArgs(Guest guest, String orderNumber, List<Product> products);
    GuestOrderEntity fromArgs(GuestEntity guest, String orderNumber);
    List<GuestOrderDetailEntity> fromArgs(GuestOrderEntity guestOrder, List<ProductEntity> products);
}
