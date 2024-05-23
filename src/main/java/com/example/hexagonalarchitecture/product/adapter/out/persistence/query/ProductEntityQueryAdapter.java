package com.example.hexagonalarchitecture.product.adapter.out.persistence.query;

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
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ProductEntityQueryAdapter implements FindProductPort {
    private final ProductEntityRepositoryCustom repositoryCustom;
    private final ProductMapper productMapper;

    @Override
    public List<Product> findByIdIn(List<Long> ids) {
        List<ProductEntity> entities = repositoryCustom.findByIdIn(ids);
        return productMapper.toDomainsWithId(entities);
    }
}
