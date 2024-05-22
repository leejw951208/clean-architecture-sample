package com.example.hexagonalarchitecture.order.adapter.out.persistence.order;

import com.example.hexagonalarchitecture.customer.adapter.out.persistence.customer.CustomerEntity;
import com.example.hexagonalarchitecture.customer.adapter.out.persistence.customer.CustomerEntityJpaRepository;
import com.example.hexagonalarchitecture.customer.adapter.out.persistence.customeruser.CustomerUserEntity;
import com.example.hexagonalarchitecture.customer.adapter.out.persistence.customeruser.CustomerUserEntityJpaRepository;
import com.example.hexagonalarchitecture.customer.shared.mapper.CustomerMapper;
import com.example.hexagonalarchitecture.order.adapter.out.persistence.orderproduct.OrderProductEntity;
import com.example.hexagonalarchitecture.order.adapter.out.persistence.orderproduct.OrderProductEntityJpaRepository;
import com.example.hexagonalarchitecture.order.application.port.out.SaveOrderPort;
import com.example.hexagonalarchitecture.order.application.port.out.FindOrderPort;
import com.example.hexagonalarchitecture.order.domain.CommandOrder;
import com.example.hexagonalarchitecture.order.domain.QueryOrder;
import com.example.hexagonalarchitecture.order.shared.mapper.OrderMapper;
import com.example.hexagonalarchitecture.product.adapter.out.persistence.ProductEntity;
import com.example.hexagonalarchitecture.product.domain.Product;
import com.example.hexagonalarchitecture.product.shared.mapper.ProductMapper;
import com.example.hexagonalarchitecture.user.adapter.out.persistence.user.UserEntity;
import com.example.hexagonalarchitecture.user.adapter.out.persistence.user.UserEntityRepositoryCustom;
import com.example.hexagonalarchitecture.user.domain.User;
import com.example.hexagonalarchitecture.user.shared.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Repository
@RequiredArgsConstructor
public class OrderEntityPersistenceAdapter implements FindOrderPort, SaveOrderPort {
    private final OrderEntityJpaRepository orderEntityJpaRepository;
    private final OrderEntityRepositoryCustom orderEntityRepositoryCustom;
    private final OrderProductEntityJpaRepository orderProductEntityJpaRepository;
    private final CustomerEntityJpaRepository customerEntityJpaRepository;
    private final CustomerUserEntityJpaRepository customerUserEntityJpaRepository;
    private final UserEntityRepositoryCustom userEntityRepositoryCustom;
    private final OrderMapper orderMapper;
    private final ProductMapper productMapper;
    private final CustomerMapper customerMapper;
    private final UserMapper userMapper;

    @Override
    @Transactional(readOnly = true)
    public QueryOrder findDomainById(Long id) {
        return orderEntityRepositoryCustom.findDomainById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> findProductByOrderId(Long orderId) {
        return orderEntityRepositoryCustom.findProductByOrderId(orderId);
    }

    @Override
    @Transactional
    public void save(CommandOrder order) {
        CustomerEntity customerEntity = customerMapper.toEntity(order.getCustomer());
        customerEntityJpaRepository.save(customerEntity);

        OrderEntity orderEntity = orderMapper.toEntity(order, customerEntity);
        orderEntityJpaRepository.save(orderEntity);

        List<ProductEntity> productEntities = productMapper.toEntitiesWithId(order.getProducts());
        List<OrderProductEntity> orderProductEntities = orderMapper.toEntities(orderEntity, productEntities);
        orderProductEntityJpaRepository.saveAll(orderProductEntities);
    }

    @Override
    public void save(CommandOrder order, User user) {
        CustomerEntity customerEntity = customerMapper.toEntity(order.getCustomer());
        customerEntityJpaRepository.save(customerEntity);

        UserEntity userEntity = userMapper.toEntity(user);
        CustomerUserEntity createdCustomerUser = customerMapper.toEntity(customerEntity, userEntity);
        customerUserEntityJpaRepository.save(createdCustomerUser);

        OrderEntity orderEntity = orderMapper.toEntity(order, customerEntity);
        orderEntityJpaRepository.save(orderEntity);

        List<ProductEntity> productEntities = productMapper.toEntitiesWithId(order.getProducts());
        List<OrderProductEntity> orderProductEntities = orderMapper.toEntities(orderEntity, productEntities);
        orderProductEntityJpaRepository.saveAll(orderProductEntities);
    }
}
