package com.example.hexagonalarchitecture.product.unit;

import com.example.hexagonalarchitecture.base.BaseUnitTest;
import com.example.hexagonalarchitecture.product.adapter.out.persistence.ProductEntity;
import com.example.hexagonalarchitecture.product.adapter.out.persistence.ProductEntityJpaRepository;
import com.example.hexagonalarchitecture.product.adapter.out.persistence.ProductEntityRepository;
import com.example.hexagonalarchitecture.product.adapter.out.persistence.command.ProductEntityCommandAdapter;
import com.example.hexagonalarchitecture.product.adapter.out.persistence.query.ProductEntityQueryAdapter;
import com.example.hexagonalarchitecture.product.domain.Product;
import com.example.hexagonalarchitecture.product.domain.ProductSave;
import com.example.hexagonalarchitecture.product.domain.ProductUpdate;
import com.example.hexagonalarchitecture.product.shared.mapper.ProductMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.*;

public class ProductAdapterTest extends BaseUnitTest {
    @Mock
    private ProductMapper productMapper;

    @Mock
    private ProductEntityJpaRepository productEntityJpaRepository;

    @Mock
    private ProductEntityRepository productEntityRepository;

    @InjectMocks
    private ProductEntityCommandAdapter productEntityCommandAdapter;

    @InjectMocks
    private ProductEntityQueryAdapter productEntityQueryAdapter;

    @Test
    @DisplayName("어댑터 단위테스트: 상품 저장")
    public void saveProduct() {
        // given
        String name = "product1";
        ProductSave productSave = ProductSave.builder().name(name).build();
        ProductEntity productEntity = ProductEntity.builder().name(productSave.getName()).build();

        given(productMapper.fromProductSave(productSave)).willReturn(productEntity);
        given(productEntityJpaRepository.save(productEntity)).willReturn(productEntity);

        // when
        productEntityCommandAdapter.save(productSave);

        // then
        then(productEntityJpaRepository).should(times(1)).save(productEntity);
        assertThat(productEntity.getName()).isEqualTo(name);
    }

    @Test
    @DisplayName("어댑터 단위테스트: 상품 조회")
    public void findProduct() {
        // given
        long id = 1L;
        String name = "product1";
        ProductEntity productEntity = ProductEntity.builder().id(id).name(name).build();
        Product product = Product.builder().id(id).name(productEntity.getName()).build();

        given(productEntityRepository.findById(id)).willReturn(Optional.of(productEntity));
        given(productMapper.fromEntity(productEntity)).willReturn(product);

        // when
        Product findProduct = productEntityQueryAdapter.findById(id);

        // then
        then(productEntityRepository).should(times(1)).findById(id);
        assertThat(findProduct).isEqualTo(product);
    }

    @Test
    @DisplayName("어댑터 단위테스트: 상품명 수정")
    public void updateProductName() {
        long id = 1L;
        String updateName = "goods1";
        ProductUpdate productUpdate = ProductUpdate.builder().id(id).name(updateName).build();
        ProductEntity productEntity = ProductEntity.builder().id(productUpdate.getId()).name(productUpdate.getName()).build();

        given(productMapper.fromProductUpdate(productUpdate)).willReturn(productEntity);

        // when
        productEntityCommandAdapter.update(productUpdate);

        // then
        assertThat(productEntity.getName()).isEqualTo(productUpdate.getName());
    }
}
