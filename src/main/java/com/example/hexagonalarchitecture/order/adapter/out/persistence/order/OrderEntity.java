package com.example.hexagonalarchitecture.order.adapter.out.persistence.order;

import com.example.hexagonalarchitecture.order.adapter.out.persistence.customer.CustomerEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Comment;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.UUID;


@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(name = "t_order")
@Entity
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private CustomerEntity customerEntity;

    @Column(name = "order_no", unique = true, nullable = false, length = 50)
    private String orderNo;

    @Comment("1: 준비, 2: 배송중, 3: 배송완료, 4: 취소")
    @ColumnDefault("1")
    @Column(name = "order_status", length = 1)
    private int orderStatus = 1;

    @CreatedDate
    @Column(name = "order_date", nullable = false)
    private LocalDateTime orderDate;

    public void updateStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }
}
