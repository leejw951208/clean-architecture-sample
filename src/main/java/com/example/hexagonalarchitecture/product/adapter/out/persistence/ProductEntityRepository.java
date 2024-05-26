package com.example.hexagonalarchitecture.product.adapter.out.persistence;

import java.util.List;

public interface ProductEntityRepository {
    List<ProductEntity> findProducts(long orderId);
    List<ProductEntity> findProducts(List<Long> ids);
}
