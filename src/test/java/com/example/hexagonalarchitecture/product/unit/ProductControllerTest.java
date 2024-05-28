package com.example.hexagonalarchitecture.product.unit;

import com.example.hexagonalarchitecture.base.BaseUnitTest;
import com.example.hexagonalarchitecture.product.adapter.in.web.ProductCommandController;
import com.example.hexagonalarchitecture.product.adapter.in.web.ProductQueryController;
import com.example.hexagonalarchitecture.product.adapter.in.web.dto.ProductFindDto;
import com.example.hexagonalarchitecture.product.adapter.in.web.dto.ProductSaveDto;
import com.example.hexagonalarchitecture.product.application.port.in.ProductFindUseCases;
import com.example.hexagonalarchitecture.product.application.port.in.ProductSaveUseCases;
import com.example.hexagonalarchitecture.product.application.port.in.ProductUpdateUseCases;
import com.example.hexagonalarchitecture.product.domain.Product;
import com.example.hexagonalarchitecture.product.shared.mapper.ProductMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = {ProductCommandController.class, ProductQueryController.class})
public class ProductControllerTest extends BaseUnitTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ProductMapper productMapper;

    @MockBean
    private ProductSaveUseCases productSaveUseCases;

    @MockBean
    private ProductFindUseCases productFindUseCases;

    @MockBean
    private ProductUpdateUseCases productUpdateUseCases;

    @Test
    @DisplayName("컨트롤러 단위테스트: 상품 저장")
    public void saveProduct() throws Exception {
        // given
        String name = "product1";
        ProductSaveDto dto = ProductSaveDto.builder().name(name).build();
        String requestContent = objectMapper.writeValueAsString(dto);

        willDoNothing().given(productSaveUseCases).saveProduct(dto.getName());

        // when
        ResultActions actions = mockMvc.perform(post("/api/product")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestContent)
        );

        // then
        actions.andExpect(status().isCreated())
                .andExpect(jsonPath("$").value("succeed"))
                .andDo(print());
    }

    @Test
    @DisplayName("컨트롤러 단위테스트: 상품 조회")
    public void findProduct() throws Exception {
        // given
        long id = 1L;
        String name = "product1";
        Product product = Product.builder().id(id).name(name).build();
        ProductFindDto dto = ProductFindDto.builder().id(id).name(product.getName()).build();
        String responseContent = objectMapper.writeValueAsString(dto);

        given(productFindUseCases.findProduct(id)).willReturn(product);
        given(productMapper.fromProductToProductFindDto(product)).willReturn(dto);

        // when
        ResultActions actions = mockMvc.perform(get("/api/product/{id}", id)
                .contentType(MediaType.APPLICATION_JSON)
        );

        // then
        actions.andExpect(status().isOk())
                .andExpect(content().json(responseContent))
                .andDo(print());

    }

    @Test
    @DisplayName("컨트롤러 단위테스트: 상풍명 수정")
    public void updateProductName() throws Exception {
        // given
        long id = 1L;
        String name = "product1";
        ProductSaveDto dto = ProductSaveDto.builder().name(name).build();
        String requestContent = objectMapper.writeValueAsString(dto);

        willDoNothing().given(productUpdateUseCases).updateProduct(id, dto.getName());

        // when
        ResultActions actions = mockMvc.perform(put("/api/product/{id}", id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestContent)
        );

        // then
        actions.andExpect(status().isOk())
                .andExpect(jsonPath("$").value("succeed"))
                .andDo(print());
    }
}
