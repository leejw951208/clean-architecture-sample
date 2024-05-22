package com.example.hexagonalarchitecture.order.domain;

import com.example.hexagonalarchitecture.product.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private Long id;
    private String customerName;
    private int orderStatus;
    private LocalDateTime orderDate;

    @Builder.Default
    private List<Product> products = new ArrayList<>();
}
