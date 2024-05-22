package com.example.hexagonalarchitecture.product.application.port.out;

import com.example.hexagonalarchitecture.product.domain.Product;

import java.util.List;

public interface FindProductPort {
    Product findById(Long id);
    List<Product> findByIdIn(List<Long> ids);
}
