package com.example.hexagonalarchitecture.product.adapter.out.persistence;

import com.example.hexagonalarchitecture.product.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductEntityRepositoryCustom {
    Optional<ProductEntity> findById(Long id);
}
