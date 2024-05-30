package com.example.hexagonalarchitecture.product.unit;

import com.example.hexagonalarchitecture.base.BaseTest;
import com.example.hexagonalarchitecture.product.application.port.out.ProductFindPort;
import com.example.hexagonalarchitecture.product.application.port.out.ProductSavePort;
import com.example.hexagonalarchitecture.product.application.port.out.ProductUpdatePort;
import com.example.hexagonalarchitecture.product.application.service.ProductFindService;
import com.example.hexagonalarchitecture.product.application.service.ProductSaveService;
import com.example.hexagonalarchitecture.product.application.service.ProductUpdateService;
import com.example.hexagonalarchitecture.product.domain.Product;
import com.example.hexagonalarchitecture.product.domain.ProductSave;
import com.example.hexagonalarchitecture.product.domain.ProductUpdate;
import com.example.hexagonalarchitecture.product.shared.mapper.ProductMapperImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest extends BaseTest {
    @Mock
    private ProductMapperImpl productMapper;

    @Mock
    private ProductSavePort productSavePort;

    @Mock
    private ProductFindPort productFindPort;

    @Mock
    private ProductUpdatePort productUpdatePort;

    @InjectMocks
    private ProductSaveService productSaveService;

    @InjectMocks
    private ProductFindService productFindService;

    @InjectMocks
    private ProductUpdateService productUpdateService;

    @Test
    @DisplayName("서비스 단위테스트: 상품 저장")
    public void saveProduct() {
        // given
        String name = "product1";
        ProductSave productSave = ProductSave.builder().name(name).build();

        given(productMapper.fromString(name)).willReturn(productSave);
        willDoNothing().given(productSavePort).save(productSave);

        // when
        productSaveService.saveProduct(name);

        // then
        then(productSavePort).should(times(1)).save(productSave);
        assertThat(productSave.getName()).isEqualTo(name);
    }

    @Test
    @DisplayName("서비스 단위테스트: 상품 조회")
    public void findProduct() {
        // given
        long id = 1L;
        Product product = Product.builder().id(id).name("product1").build();
        given(productFindPort.findById(id)).willReturn(product);

        // when
        Product findProduct = productFindService.findProduct(id);

        // then
        then(productFindPort).should(times(1)).findById(id);
        assertThat(product).isEqualTo(findProduct);
    }

    @Test
    @DisplayName("서비스 단위테스트: 상품명 수정")
    public void updateProduct() {
        // given
        long id = 1L;
        String updateName = "goods1";
        Product product = Product.builder().id(id).name("product1").build();
        ProductUpdate productUpdate = ProductUpdate.builder().id(id).name(updateName).build();

        given(productFindPort.findById(id)).willReturn(product);
        given(productMapper.fromProductToProductUpdate(product)).willReturn(productUpdate);
        willDoNothing().given(productUpdatePort).update(productUpdate);

        // when
        productUpdateService.updateProduct(id, updateName);

        // then
        then(productUpdatePort).should(times(1)).update(productUpdate);
        assertThat(updateName).isEqualTo(productUpdate.getName());
    }
}

