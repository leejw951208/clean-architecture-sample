package com.example.hexagonalarchitecture.customer.adapter.out.persistence.customeruser;

import com.example.hexagonalarchitecture.customer.adapter.out.persistence.customer.CustomerEntity;
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
@Table(name = "t_user_customer")
@Entity
public class CustomerUserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private CustomerEntity customerEntity;

    @CreatedDate
    @Column(name = "created_date", nullable = false)
    private LocalDateTime createdDate;
}
