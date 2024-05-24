package com.example.hexagonalarchitecture.order.domain.user;

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
public class UserOrder {
    private Long id;
    private String name;
    private String orderNo;
    private int orderStatus;
    private LocalDateTime orderDate;

    @Builder.Default
    private List<Product> products = new ArrayList<>();

    public void setProducts(Map<Long, List<Product>> productMap) {
        products = productMap.get(id);
    }
}
