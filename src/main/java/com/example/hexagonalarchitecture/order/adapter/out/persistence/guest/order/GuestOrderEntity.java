package com.example.hexagonalarchitecture.order.adapter.out.persistence.guest.order;

import com.example.hexagonalarchitecture.guest.adapter.out.persistence.GuestEntity;
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
@Table(name = "t_guest_order")
@Entity
public class GuestOrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "guest_id", nullable = false)
    private GuestEntity guest;

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
