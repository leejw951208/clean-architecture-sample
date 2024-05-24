package com.example.hexagonalarchitecture.order.adapter.out.persistence.user.order;

import java.util.Optional;

public interface UserOrderEntityRepository {
    Optional<String> findLastOrderNumber();
}
