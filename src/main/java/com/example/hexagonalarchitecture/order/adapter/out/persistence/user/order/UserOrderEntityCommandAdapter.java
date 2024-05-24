package com.example.hexagonalarchitecture.order.adapter.out.persistence.user.order;

import com.example.hexagonalarchitecture.order.adapter.out.persistence.user.detail.UserOrderDetailEntity;
import com.example.hexagonalarchitecture.order.adapter.out.persistence.user.detail.UserOrderDetailEntityJpaRepository;
import com.example.hexagonalarchitecture.order.application.port.out.SaveUserOrderPort;
import com.example.hexagonalarchitecture.order.domain.user.UserOrderCommand;
import com.example.hexagonalarchitecture.order.shared.mapper.user.UserOrderMapper;
import com.example.hexagonalarchitecture.product.adapter.out.persistence.ProductEntity;
import com.example.hexagonalarchitecture.product.shared.mapper.ProductMapper;
import com.example.hexagonalarchitecture.user.adapter.out.persistence.user.UserEntity;
import com.example.hexagonalarchitecture.user.shared.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserOrderEntityCommandAdapter implements SaveUserOrderPort {
    private final UserOrderEntityJpaRepository userOrderEntityJpaRepository;
    private final UserOrderDetailEntityJpaRepository userOrderDetailEntityJpaRepository;

    private final UserOrderMapper userOrderMapper;
    private final UserMapper userMapper;
    private final ProductMapper productMapper;

    @Override
    public void save(UserOrderCommand domain) {
        UserEntity user = userMapper.toEntity(domain.getUser());
        UserOrderEntity userOrder = userOrderMapper.toEntity(user, domain.getOrderNumber());
        UserOrderEntity savedUserOrder = userOrderEntityJpaRepository.save(userOrder);

        List<ProductEntity> products = productMapper.toEntity(domain.getProducts());
        List<UserOrderDetailEntity> userOrderDetails = userOrderMapper.toEntity(savedUserOrder, products);
        userOrderDetailEntityJpaRepository.saveAll(userOrderDetails);
    }
}
