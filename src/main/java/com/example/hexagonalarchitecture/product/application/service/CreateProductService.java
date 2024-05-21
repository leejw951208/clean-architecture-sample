package com.example.hexagonalarchitecture.product.application.service;

import com.example.hexagonalarchitecture.product.adapter.in.web.dto.CreateProductRequestDto;
import com.example.hexagonalarchitecture.product.application.port.in.CreateProductUseCase;
import com.example.hexagonalarchitecture.product.application.port.out.CreateProductPort;
import com.example.hexagonalarchitecture.product.domain.Product;
import com.example.hexagonalarchitecture.product.shared.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CreateProductService implements CreateProductUseCase {
    private final CreateProductPort createProductPort;
    private final ProductMapper productMapper;

    @Override
    public void createProduct(CreateProductRequestDto dto) {
        Product domain = productMapper.toDomain(dto);
        createProductPort.createProduct(domain);
    }

    @Override
    public void createProducts(List<CreateProductRequestDto> dtos) {
        List<Product> domains = productMapper.toDomains(dtos);
        createProductPort.createProducts(domains);
    }
}
