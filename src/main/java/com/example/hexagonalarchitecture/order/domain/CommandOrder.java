package com.example.hexagonalarchitecture.order.domain;

import com.example.hexagonalarchitecture.customer.domain.Customer;
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
public class CommandOrder {
    private Long id;
    private Customer customer;
    private List<Product> products;
}
