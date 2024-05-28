package com.example.hexagonalarchitecture.product.application.port.out;

import com.example.hexagonalarchitecture.product.domain.Product;

import java.util.List;

public interface ProductFindPort {
    List<Product> findByOrderId(long orderId);
    List<Product> findByIds(List<Long> ids);
    Product findById(long id);
}
