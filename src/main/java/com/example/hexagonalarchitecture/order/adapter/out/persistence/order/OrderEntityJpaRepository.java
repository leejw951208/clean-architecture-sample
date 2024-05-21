package com.example.hexagonalarchitecture.order.adapter.out.persistence.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderEntityJpaRepository extends JpaRepository<OrderEntity, Long> {
}
