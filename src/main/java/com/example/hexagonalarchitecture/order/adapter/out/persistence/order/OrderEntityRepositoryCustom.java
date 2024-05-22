package com.example.hexagonalarchitecture.order.adapter.out.persistence.order;

import com.example.hexagonalarchitecture.order.domain.QueryOrder;
import com.example.hexagonalarchitecture.product.domain.Product;

import java.util.List;
import java.util.Optional;

public interface OrderEntityRepositoryCustom {
    Optional<OrderEntity> findById(Long id);
    Optional<QueryOrder> findDomainById(Long id);
    List<Product> findProductByOrderId(Long orderId);
}
