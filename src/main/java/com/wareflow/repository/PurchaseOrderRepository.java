package com.wareflow.repository;

import com.wareflow.entity.PurchaseOrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrderItem,Long> {

}
