package com.example.hexagonalarchitecture.order.adapter.out.persistence.customeruser;

import com.example.hexagonalarchitecture.order.adapter.out.persistence.customer.CustomerEntity;
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
@Table(name = "t_customer_user")
@Entity
public class CustomerUserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private CustomerEntity customerEntity;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity userEntity;

    @CreatedDate
    @Column(name = "created_date", nullable = false)
    private LocalDateTime createdDate;
}
