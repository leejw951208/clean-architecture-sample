package com.example.hexagonalarchitecture.order.adapter.out.persistence.order.command;

import com.example.hexagonalarchitecture.order.adapter.out.persistence.customer.CustomerEntity;
import com.example.hexagonalarchitecture.order.adapter.out.persistence.customer.CustomerEntityJpaRepository;
import com.example.hexagonalarchitecture.order.adapter.out.persistence.customer.CustomerEntityRepositoryCustom;
import com.example.hexagonalarchitecture.order.adapter.out.persistence.customeruser.CustomerUserEntity;
import com.example.hexagonalarchitecture.order.adapter.out.persistence.customeruser.CustomerUserEntityJpaRepository;
import com.example.hexagonalarchitecture.order.domain.Customer;
import com.example.hexagonalarchitecture.order.shared.mapper.CustomerMapper;
import com.example.hexagonalarchitecture.order.adapter.out.persistence.order.OrderEntity;
import com.example.hexagonalarchitecture.order.adapter.out.persistence.order.OrderEntityJpaRepository;
import com.example.hexagonalarchitecture.order.adapter.out.persistence.orderproduct.OrderProductEntity;
import com.example.hexagonalarchitecture.order.adapter.out.persistence.orderproduct.OrderProductEntityJpaRepository;
import com.example.hexagonalarchitecture.order.application.port.out.SaveOrderPort;
import com.example.hexagonalarchitecture.order.shared.mapper.OrderMapper;
import com.example.hexagonalarchitecture.product.adapter.out.persistence.ProductEntity;
import com.example.hexagonalarchitecture.product.adapter.out.persistence.ProductEntityRepositoryCustom;
import com.example.hexagonalarchitecture.product.domain.Product;
import com.example.hexagonalarchitecture.product.shared.mapper.ProductMapper;
import com.example.hexagonalarchitecture.user.adapter.out.persistence.user.UserEntity;
import com.example.hexagonalarchitecture.user.adapter.out.persistence.user.UserEntityRepositoryCustom;
import com.example.hexagonalarchitecture.user.domain.User;
import com.example.hexagonalarchitecture.user.shared.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.NoSuchElementException;

@Repository
@RequiredArgsConstructor
public class OrderEntityCommandAdapter implements SaveOrderPort {
    private final OrderEntityJpaRepository orderEntityJpaRepository;
    private final OrderProductEntityJpaRepository orderProductEntityJpaRepository;
    private final CustomerEntityJpaRepository customerEntityJpaRepository;
    private final CustomerUserEntityJpaRepository customerUserEntityJpaRepository;
    private final CustomerEntityRepositoryCustom customerEntityRepositoryCustom;
    private final ProductEntityRepositoryCustom productEntityRepositoryCustom;
    private final UserEntityRepositoryCustom userEntityRepositoryCustom;
    private final OrderMapper orderMapper;
    private final CustomerMapper customerMapper;

    @Override
    public void save(long userId, List<Long> productIds) {
        UserEntity userEntity = userEntityRepositoryCustom.findById(userId).orElseThrow(NoSuchElementException::new);
        List<ProductEntity> productEntities = productEntityRepositoryCustom.findByIdIn(productIds);
        CustomerEntity customerEntity = customerEntityRepositoryCustom.findByUserId(userId)
                .orElseGet(() -> {
                    CustomerEntity newCustomerEntity = customerMapper.toEntity(userEntity.getName(), 1);
                    CustomerEntity savedCustomerEntity = customerEntityJpaRepository.save(newCustomerEntity);
                    CustomerUserEntity customerUserEntity = customerMapper.toEntity(savedCustomerEntity, userEntity);
                    customerUserEntityJpaRepository.save(customerUserEntity);
                    return savedCustomerEntity;
                });
        customerEntity.update(userEntity.getName());
        save(customerEntity, productEntities);
    }

    @Override
    public void save(String name, List<Long> productIds) {
        List<ProductEntity> productEntities = productEntityRepositoryCustom.findByIdIn(productIds);
        CustomerEntity customerEntity = customerMapper.toEntity(name, 2);
        CustomerEntity savedCustomerEntity = customerEntityJpaRepository.save(customerEntity);
        save(savedCustomerEntity, productEntities);
    }

    private void save(CustomerEntity customerEntity, List<ProductEntity> productEntities) {
        OrderEntity orderEntity = orderMapper.toEntity(customerEntity);
        OrderEntity savedOrderEntity = orderEntityJpaRepository.save(orderEntity);

        List<OrderProductEntity> orderProductEntities = orderMapper.toEntities(savedOrderEntity, productEntities);
        orderProductEntityJpaRepository.saveAll(orderProductEntities);
    }
}
