package com.example.hexagonalarchitecture.product.application.port.out;

import com.example.hexagonalarchitecture.product.domain.Product;
import com.example.hexagonalarchitecture.product.domain.ProductSave;

import java.util.List;

public interface ProductSavePort {
    List<Product> saveAll(List<ProductSave> products);
}
