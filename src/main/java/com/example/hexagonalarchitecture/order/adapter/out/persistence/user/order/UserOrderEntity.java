package com.example.hexagonalarchitecture.order.adapter.out.persistence.user.order;

import com.example.hexagonalarchitecture.user.adapter.out.persistence.user.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(name = "t_user_order")
@Entity
public class UserOrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @Column(name = "order_number", nullable = false)
    private String orderNumber;

    @Column(name = "post_number", nullable = false, length = 6)
    private String postNumber;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "address_detail", nullable = false)
    private String addressDetail;

    @CreatedDate
    @Column(name = "order_date", nullable = false)
    private LocalDateTime orderDate;
}
