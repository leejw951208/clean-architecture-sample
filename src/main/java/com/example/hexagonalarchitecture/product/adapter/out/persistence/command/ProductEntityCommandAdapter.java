package com.example.hexagonalarchitecture.product.adapter.out.persistence.command;

import com.example.hexagonalarchitecture.product.adapter.out.persistence.ProductEntity;
import com.example.hexagonalarchitecture.product.adapter.out.persistence.ProductEntityJpaRepository;
import com.example.hexagonalarchitecture.product.adapter.out.persistence.ProductEntityRepositoryCustom;
import com.example.hexagonalarchitecture.product.application.port.out.CreateProductPort;
import com.example.hexagonalarchitecture.product.application.port.out.FindProductPort;
import com.example.hexagonalarchitecture.product.domain.Product;
import com.example.hexagonalarchitecture.product.shared.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Repository
@RequiredArgsConstructor
public class ProductEntityCommandAdapter implements CreateProductPort {
    private final ProductEntityJpaRepository repository;
    private final ProductMapper productMapper;

    @Override
    @Transactional
    public void save(Product product) {
        ProductEntity entity = productMapper.toEntity(product);
        repository.save(entity);
    }

    @Override
    @Transactional
    public void saveAll(List<Product> products) {
        List<ProductEntity> entities = productMapper.toEntitiesWithId(products);
        repository.saveAll(entities);
    }
}
