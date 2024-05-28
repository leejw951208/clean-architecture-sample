package com.example.hexagonalarchitecture.product.integration;

import com.example.hexagonalarchitecture.product.adapter.out.persistence.ProductEntity;
import com.example.hexagonalarchitecture.product.adapter.out.persistence.ProductEntityJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@Component
public class ProductSetUp {
    @Autowired
    private ProductEntityJpaRepository productEntityJpaRepository;

    public Long saveProduct(String name) {
        ProductEntity productEntity = ProductEntity.builder()
                .name(name)
                .build();
        return productEntityJpaRepository.save(productEntity).getId();
    }

    public ProductEntity findProduct(long id) {
        return productEntityJpaRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("상품을 찾을 수 없습니다."));
    }
}
