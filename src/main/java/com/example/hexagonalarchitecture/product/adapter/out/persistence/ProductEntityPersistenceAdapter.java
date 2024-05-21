package com.example.hexagonalarchitecture.product.adapter.out.persistence;

import com.example.hexagonalarchitecture.product.application.port.out.CreateProductPort;
import com.example.hexagonalarchitecture.product.domain.Product;
import com.example.hexagonalarchitecture.product.shared.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductEntityPersistenceAdapter implements CreateProductPort {
    private final ProductEntityJpaRepository repository;
    private final ProductMapper productMapper;

    @Override
    @Transactional
    public void createProduct(Product product) {
        ProductEntity entity = productMapper.toEntity(product);
        repository.save(entity);
    }

    @Override
    @Transactional
    public void createProducts(List<Product> products) {
        List<ProductEntity> entities = productMapper.toEntities(products);
        repository.saveAll(entities);
    }
}
