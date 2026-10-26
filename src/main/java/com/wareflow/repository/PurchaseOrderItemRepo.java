package com.wareflow.repository;

import com.wareflow.entity.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseOrderItemRepo extends JpaRepository<PurchaseOrder,Long> {
}
