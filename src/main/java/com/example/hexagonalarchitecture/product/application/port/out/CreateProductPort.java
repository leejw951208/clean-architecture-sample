package com.example.hexagonalarchitecture.product.application.port.out;

import com.example.hexagonalarchitecture.product.domain.Product;

import java.util.List;

public interface CreateProductPort {
    void createProduct(Product product);
    void createProducts(List<Product> products);
}
