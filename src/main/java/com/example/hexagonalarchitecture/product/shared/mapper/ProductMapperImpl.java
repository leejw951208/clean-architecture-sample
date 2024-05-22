package com.example.hexagonalarchitecture.product.shared.mapper;

import com.example.hexagonalarchitecture.product.adapter.in.web.dto.CreateProductRequestDto;
import com.example.hexagonalarchitecture.product.adapter.out.persistence.ProductEntity;
import com.example.hexagonalarchitecture.product.domain.Product;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapperImpl implements ProductMapper {
    @Override
    public ProductEntity toEntity(Product domain) {
        return ProductEntity.builder()
                .productName(domain.getProductName())
                .build();
    }

    @Override
    public Product toDomain(ProductEntity entity) {
        return Product.builder()
                .id(entity.getId())
                .productName(entity.getProductName())
                .createdDate(entity.getCreatedDate())
                .build();
    }

    @Override
    public List<Product> toDomainsWithId(List<ProductEntity> entities) {
        return entities.stream()
                .map(entity -> Product.builder()
                        .id(entity.getId())
                        .productName(entity.getProductName())
                        .createdDate(entity.getCreatedDate()).build()
                )
                .collect(Collectors.toList());
    }

    @Override
    public Product toDomain(CreateProductRequestDto dto) {
        return Product.builder()
                .productName(dto.getProductName())
                .build();
    }

    @Override
    public List<Product> toDomainsFromDto(List<CreateProductRequestDto> dtos) {
        return dtos.stream()
                .map(dto -> Product.builder().productName(dto.getProductName()).build())
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductEntity> toEntitiesWithId(List<Product> domains) {
        return domains.stream()
                .map(domain -> ProductEntity.builder()
                        .id(domain.getId())
                        .productName(domain.getProductName())
                        .createdDate(domain.getCreatedDate())
                        .build()
                )
                .collect(Collectors.toList());
    }
}
