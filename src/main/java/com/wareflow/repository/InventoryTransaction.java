package com.wareflow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryTransaction extends JpaRepository<com.wareflow.entity.InventoryTransaction,Long> {

}
