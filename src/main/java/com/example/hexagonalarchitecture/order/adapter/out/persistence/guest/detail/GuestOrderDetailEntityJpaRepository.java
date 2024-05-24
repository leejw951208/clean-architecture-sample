package com.example.hexagonalarchitecture.order.adapter.out.persistence.guest.detail;

import com.example.hexagonalarchitecture.order.adapter.out.persistence.user.order.UserOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestOrderDetailEntityJpaRepository extends JpaRepository<GuestOrderDetailEntity, Long> {
}
