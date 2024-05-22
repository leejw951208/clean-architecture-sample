package com.example.hexagonalarchitecture.order.adapter.out.persistence.order;

import com.example.hexagonalarchitecture.order.adapter.out.persistence.orderProduct.OrderProductEntity;
import com.example.hexagonalarchitecture.order.adapter.out.persistence.orderProduct.OrderProductEntityJpaRepository;
import com.example.hexagonalarchitecture.order.application.port.out.CreateOrderPort;
import com.example.hexagonalarchitecture.order.application.port.out.FindOrderPort;
import com.example.hexagonalarchitecture.order.domain.Order;
import com.example.hexagonalarchitecture.order.shared.mapper.OrderMapper;
import com.example.hexagonalarchitecture.product.adapter.out.persistence.ProductEntity;
import com.example.hexagonalarchitecture.product.domain.Product;
import com.example.hexagonalarchitecture.product.shared.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Repository
@RequiredArgsConstructor
public class OrderEntityPersistenceAdapter implements FindOrderPort, CreateOrderPort {
    private final OrderEntityJpaRepository orderEntityJpaRepository;
    private final OrderEntityRepositoryCustom orderEntityRepositoryCustom;
    private final OrderProductEntityJpaRepository orderProductEntityJpaRepository;
    private final OrderMapper orderMapper;
    private final ProductMapper productMapper;

    @Override
    @Transactional(readOnly = true)
    public Order findById(Long id) {
        OrderEntity entity = orderEntityRepositoryCustom.findById(id).orElseThrow(NoSuchElementException::new);
        return orderMapper.toDomain(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> findProductByOrderId(Long orderId) {
        return orderEntityRepositoryCustom.findProductByOrderId(orderId);
    }

    @Override
    @Transactional
    public void createOrder(Order order, List<Product> products) {
        OrderEntity orderEntity = orderMapper.toEntity(order);
        orderEntityJpaRepository.save(orderEntity);

        List<ProductEntity> productEntities = productMapper.toEntitiesWithId(products);
        List<OrderProductEntity> orderProductEntities = orderMapper.toEntities(orderEntity, productEntities);
        orderProductEntityJpaRepository.saveAll(orderProductEntities);
    }
}
