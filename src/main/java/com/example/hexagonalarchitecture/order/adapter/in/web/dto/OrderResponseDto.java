package com.example.hexagonalarchitecture.order.adapter.in.web.dto;

import com.example.hexagonalarchitecture.product.domain.Product;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
public class OrderResponseDto {
    private Long id;
    private String customerName;
    private String orderNo;
    private int orderStatus;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime orderDate;

    @Builder.Default
    private List<Product> products = new ArrayList<>();
}
