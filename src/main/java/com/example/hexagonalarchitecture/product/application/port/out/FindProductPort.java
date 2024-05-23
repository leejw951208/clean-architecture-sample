package com.example.hexagonalarchitecture.product.application.port.out;

import com.example.hexagonalarchitecture.product.domain.Product;

import java.util.List;
import java.util.Optional;

public interface FindProductPort {
    List<Product> findByIdIn(List<Long> ids);
}
