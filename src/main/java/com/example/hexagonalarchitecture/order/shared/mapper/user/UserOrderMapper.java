package com.example.hexagonalarchitecture.order.shared.mapper.user;

import com.example.hexagonalarchitecture.order.adapter.out.persistence.user.detail.UserOrderDetailEntity;
import com.example.hexagonalarchitecture.order.adapter.out.persistence.user.order.UserOrderEntity;
import com.example.hexagonalarchitecture.order.domain.UserOrderSave;
import com.example.hexagonalarchitecture.product.adapter.out.persistence.ProductEntity;
import com.example.hexagonalarchitecture.product.domain.Product;
import com.example.hexagonalarchitecture.user.adapter.out.persistence.user.UserEntity;
import com.example.hexagonalarchitecture.user.domain.User;

import java.util.List;

public interface UserOrderMapper {
    UserOrderSave toDomain(User user, String orderNumber, List<Product> products);
    UserOrderEntity toEntity(UserEntity user, String orderNumber);
    List<UserOrderDetailEntity> toEntity(UserOrderEntity userOrder, List<ProductEntity> products);
}