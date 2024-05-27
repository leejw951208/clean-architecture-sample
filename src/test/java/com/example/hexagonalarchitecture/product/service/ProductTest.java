package com.example.hexagonalarchitecture.product.service;

import com.example.hexagonalarchitecture.product.adapter.out.persistence.ProductEntity;
import com.example.hexagonalarchitecture.product.adapter.out.persistence.ProductEntityRepository;
import com.example.hexagonalarchitecture.product.adapter.out.persistence.query.ProductEntityQueryAdapter;
import com.example.hexagonalarchitecture.product.domain.Product;
import com.example.hexagonalarchitecture.product.shared.mapper.ProductMapperImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class ProductTest {
    @Mock
    private ProductEntityRepository productEntityRepository;

    @InjectMocks
    private ProductEntityQueryAdapter productEntityQueryAdapter;

    @Mock
    private ProductMapperImpl productMapper;

    @Test
    @DisplayName("주문 상품 조회")
    public void findProductByOrderId() {
        // given
        long orderId = 1L;
        List<Product> products = create();
        List<ProductEntity> productEntities = new ArrayList<>();

        given(productEntityRepository.findByOrderId(orderId)).willReturn(productEntities);
        given(productMapper.fromEntities(productEntities)).willReturn(anyList());

        // when
        List<Product> findProducts = productEntityQueryAdapter.findByOrderId(orderId);

        // then
        then(productEntityRepository).should(times(1)).findByOrderId(orderId);
        assertThat(products).isEqualTo(findProducts);
    }

    private List<Product> create() {
        return List.of(Product.builder().id(1L).name("product1").build());
    }
}
