package com.example.hexagonalarchitecture.order.adapter.out.persistence.order;

import com.example.hexagonalarchitecture.order.adapter.out.persistence.orderProduct.OrderProductEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Comment;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;


@Getter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(name = "t_order")
@Entity
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "customer_name", nullable = false, length = 10)
    private String customerName;

    @Comment("1: 준비, 2: 배송중, 3: 배송완료, 4: 취소")
    @ColumnDefault("1")
    @Column(name = "order_status", length = 1)
    private int orderStatus = 1;

    @CreatedDate
    @Column(name = "order_date", nullable = false)
    private LocalDateTime orderDate;

    @Builder
    public OrderEntity(String customerName, int orderStatus, LocalDateTime orderDate) {
        this.customerName = customerName;
        this.orderStatus = orderStatus;
        this.orderDate = orderDate;
    }
}
