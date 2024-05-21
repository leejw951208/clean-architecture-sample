package com.example.hexagonalarchitecture.order.adapter.out.persistence.order;

import com.example.hexagonalarchitecture.order.application.port.out.CreateOrderPort;
import com.example.hexagonalarchitecture.order.application.port.out.FindOrderPort;
import com.example.hexagonalarchitecture.order.domain.Order;
import com.example.hexagonalarchitecture.order.shared.mapper.OrderMapper;
import com.example.hexagonalarchitecture.product.domain.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.NoSuchElementException;

@Repository
@RequiredArgsConstructor
public class OrderEntityPersistenceAdapter implements FindOrderPort, CreateOrderPort {
    private final OrderEntityJpaRepository repository;
    private final OrderEntityRepositoryCustom repositoryCustom;
    private final OrderMapper mapper;

    @Override
    public Order findById(Long id) {
        OrderEntity entity = repositoryCustom.findById(id).orElseThrow(NoSuchElementException::new);
        return mapper.toDomain(entity);
    }

    @Override
    public List<Product> findProductByOrderId(Long orderId) {
        return repositoryCustom.findProductByOrderId(orderId);
    }

    @Override
    public void createOrder(Order domain) {
        OrderEntity entity = mapper.toEntity(domain);
        repository.save(entity);
    }
}
