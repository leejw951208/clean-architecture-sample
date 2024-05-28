package com.example.hexagonalarchitecture.product.application.port.out;

import com.example.hexagonalarchitecture.product.domain.ProductSave;
import com.example.hexagonalarchitecture.product.domain.ProductUpdate;

public interface ProductUpdatePort {
    void update(ProductUpdate productUpdate);
}
