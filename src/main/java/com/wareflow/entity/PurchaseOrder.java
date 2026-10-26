package com.wareflow.entity;

import com.wareflow.enums.PurchaseOrderStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Setter
@Getter
public class PurchaseOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "supplier_id")

    private Supplier supplier;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User createdBy;

    @Enumerated(EnumType.STRING)
    private PurchaseOrderStatus status;

    private LocalDateTime createdAt;

    private LocalDateTime receivedAt;

    @OneToMany(mappedBy = "purchaseOrder")
    private List<PurchaseOrderItem> purchaseOrderItems;
}
