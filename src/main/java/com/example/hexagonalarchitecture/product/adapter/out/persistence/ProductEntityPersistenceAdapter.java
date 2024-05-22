package com.example.hexagonalarchitecture.product.adapter.out.persistence;

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
public class ProductEntityPersistenceAdapter implements CreateProductPort, FindProductPort {
    private final ProductEntityJpaRepository repository;
    private final ProductEntityRepositoryCustom repositoryCustom;
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

    @Override
    public Product findById(Long id) {
        ProductEntity findEntity = repositoryCustom.findById(id)
                .orElseThrow(NoSuchElementException::new);
        return productMapper.toDomain(findEntity);
    }

    @Override
    public List<Product> findByIdIn(List<Long> ids) {
        List<ProductEntity> entities = repositoryCustom.findByIdIn(ids);
        return productMapper.toDomainsWithId(entities);
    }
}
