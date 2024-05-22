package com.example.hexagonalarchitecture.product.shared.mapper;

import com.example.hexagonalarchitecture.product.adapter.in.web.dto.CreateProductRequestDto;
import com.example.hexagonalarchitecture.product.adapter.out.persistence.ProductEntity;
import com.example.hexagonalarchitecture.product.domain.Product;

import java.util.List;

public interface ProductMapper {
    ProductEntity toEntity(Product domain);
    Product toDomain(ProductEntity entity);
    List<Product> toDomainsWithId(List<ProductEntity> entities);
    Product toDomain(CreateProductRequestDto dto);
    List<Product> toDomainsFromDto(List<CreateProductRequestDto> dtos);
    List<ProductEntity> toEntitiesWithId(List<Product> domains);
}
