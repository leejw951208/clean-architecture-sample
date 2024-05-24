package com.example.hexagonalarchitecture.order.adapter.out.persistence.user.detail;

import com.example.hexagonalarchitecture.order.adapter.out.persistence.user.order.UserOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserOrderDetailEntityJpaRepository extends JpaRepository<UserOrderDetailEntity, Long> {
}
