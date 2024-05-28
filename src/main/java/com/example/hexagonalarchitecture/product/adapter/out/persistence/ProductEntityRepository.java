package com.example.hexagonalarchitecture.product.adapter.out.persistence;

import java.util.List;
import java.util.Optional;

public interface ProductEntityRepository {
    List<ProductEntity> findByOrderId(long orderId);
    List<ProductEntity> findByIds(List<Long> ids);
    Optional<ProductEntity> findById(long id);
}
