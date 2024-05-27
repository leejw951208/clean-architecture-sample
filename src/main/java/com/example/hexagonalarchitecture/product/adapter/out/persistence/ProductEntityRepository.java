package com.example.hexagonalarchitecture.product.adapter.out.persistence;

import java.util.List;

public interface ProductEntityRepository {
    List<ProductEntity> findByOrderId(long orderId);
    List<ProductEntity> findByIds(List<Long> ids);
}
