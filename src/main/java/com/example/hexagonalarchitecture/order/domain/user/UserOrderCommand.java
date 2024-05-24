package com.example.hexagonalarchitecture.order.domain.user;

import com.example.hexagonalarchitecture.product.domain.Product;
import com.example.hexagonalarchitecture.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserOrderCommand {
    private User user;
    private String orderNumber;
    private List<Product> products;
}
