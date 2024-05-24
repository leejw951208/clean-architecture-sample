package com.example.hexagonalarchitecture.order.adapter.out.persistence.guest.order;

import java.util.Optional;

public interface GuestOrderEntityRepository {
    Optional<String> findLastOrderNumber();
}
