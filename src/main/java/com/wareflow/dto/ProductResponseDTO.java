package com.wareflow.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDTO {

    private Long id;

    private String sku;

    private String name;

    private String description;

    private BigDecimal price;

    private int quantity;

    private int reorderLevel;

    private Long supplierId;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
