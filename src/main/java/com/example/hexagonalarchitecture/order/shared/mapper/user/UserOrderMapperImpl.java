package com.example.hexagonalarchitecture.order.shared.mapper.user;

import com.example.hexagonalarchitecture.order.adapter.out.persistence.user.detail.UserOrderDetailEntity;
import com.example.hexagonalarchitecture.order.adapter.out.persistence.user.order.UserOrderEntity;
import com.example.hexagonalarchitecture.order.domain.UserOrderSave;
import com.example.hexagonalarchitecture.product.adapter.out.persistence.ProductEntity;
import com.example.hexagonalarchitecture.product.domain.Product;
import com.example.hexagonalarchitecture.user.adapter.out.persistence.user.UserEntity;
import com.example.hexagonalarchitecture.user.domain.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserOrderMapperImpl implements UserOrderMapper {
    @Override
    public UserOrderSave toDomain(User user, String orderNumber, List<Product> products) {
        return UserOrderSave.builder()
                .user(user)
                .orderNumber(orderNumber)
                .products(products)
                .build();
    }

    @Override
    public UserOrderEntity toEntity(UserEntity user, String orderNumber) {
        return UserOrderEntity.builder()
                .user(user)
                .orderNumber(orderNumber)
                .postNumber("12345")
                .address("테스트")
                .addressDetail("입니다")
                .build();
    }

    @Override
    public List<UserOrderDetailEntity> toEntity(UserOrderEntity userOrder, List<ProductEntity> products) {
        return products.stream()
                .map(product -> UserOrderDetailEntity.builder()
                        .userOrder(userOrder)
                        .product(product)
                        .orderStatus(1)
                        .build()
                )
                .toList();
    }

}
