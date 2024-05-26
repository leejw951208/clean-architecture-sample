package com.example.hexagonalarchitecture.product.adapter.out.persistence.command;

import com.example.hexagonalarchitecture.product.adapter.out.persistence.ProductEntity;
import com.example.hexagonalarchitecture.product.adapter.out.persistence.ProductEntityJpaRepository;
import com.example.hexagonalarchitecture.product.application.port.out.ProductSavePort;
import com.example.hexagonalarchitecture.product.domain.Product;
import com.example.hexagonalarchitecture.product.domain.ProductSave;
import com.example.hexagonalarchitecture.product.shared.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductEntityCommandAdapter implements ProductSavePort {
    private final ProductEntityJpaRepository productEntityJpaRepository;
    private final ProductMapper productMapper;

    @Override
    @Transactional
    public List<Product> saveAll(List<ProductSave> products) {
        List<ProductEntity> productEntities = productMapper.fromProductSaves(products);
        List<ProductEntity> savedProductEntities = productEntityJpaRepository.saveAll(productEntities);
        return productMapper.fromEntities(savedProductEntities);
    }
}
