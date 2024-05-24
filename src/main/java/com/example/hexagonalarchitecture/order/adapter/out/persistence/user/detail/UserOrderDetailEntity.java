package com.example.hexagonalarchitecture.order.adapter.out.persistence.user.detail;

import com.example.hexagonalarchitecture.order.adapter.out.persistence.user.order.UserOrderEntity;
import com.example.hexagonalarchitecture.product.adapter.out.persistence.ProductEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Comment;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(name = "t_user_order_detail", indexes = {@Index(columnList = "tracking_number")})
@Entity
public class UserOrderDetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_order_id")
    private UserOrderEntity userOrder;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private ProductEntity product;

    @Column(name = "tracking_number")
    private String trackingNumber;

    @Comment("1: 준비, 2: 배송중, 3: 배송완료, 4: 취소")
    @ColumnDefault("1")
    @Column(name = "order_status", nullable = false, length = 1)
    private int orderStatus;
}
