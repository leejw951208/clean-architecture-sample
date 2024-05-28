package com.example.hexagonalarchitecture.product.application.port.in;

import com.example.hexagonalarchitecture.product.domain.Product;
import com.example.hexagonalarchitecture.product.domain.ProductSave;

import java.util.List;

public interface ProductSaveUseCases {
    void saveProduct(String name);
}
