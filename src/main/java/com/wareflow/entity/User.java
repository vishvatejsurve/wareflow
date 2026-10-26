package com.wareflow.entity;

import com.wareflow.enums.UserRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Setter
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    private boolean enabled;

    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "user")
    private List<InventoryTransaction> inventoryTransactions;

    @OneToMany (mappedBy = "createdBy")
    private List<PurchaseOrder> purchaseOrders;
}
