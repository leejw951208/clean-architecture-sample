package com.example.hexagonalarchitecture.product.application.port.in;

import com.example.hexagonalarchitecture.product.domain.ProductUpdate;

public interface ProductUpdateUseCases {
    void updateProduct(long id, String name);
}
