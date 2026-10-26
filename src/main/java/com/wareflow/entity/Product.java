package com.wareflow.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;



import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "product")
@Setter
@Getter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    @NotBlank
    private String sku;

    @Column(nullable = false)
    @NotBlank
    private String name;

    private  String description;

    @NotNull @Positive
    private BigDecimal price;

    @PositiveOrZero
    private int quantity;

    @PositiveOrZero
    private int reorderLevel;

    @Version
    private Long version;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "product")
    private List<InventoryTransaction> inventoryTransactions;

    @OneToMany(mappedBy = "product")
    private List<PurchaseOrderItem> purchaseOrderItems;
}
