package com.example.hexagonalarchitecture.order.domain;

import com.example.hexagonalarchitecture.product.domain.Product;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private Long id;
    private String customerName;
    private String orderNo;
    private int orderStatus;
    private LocalDateTime orderDate;

    @Builder.Default
    private List<Product> products = new ArrayList<>();

    public void setProducts(Map<Long, List<Product>> productMap) {
        products = productMap.get(id);
    }
}
