package com.wareflow.service;

import com.wareflow.dto.SupplierRequestDTO;
import com.wareflow.dto.SupplierResponseDTO;

import java.util.List;

public interface SupplierService {
    SupplierResponseDTO createSupplier(SupplierRequestDTO supplierRequestDTO);
    List<SupplierResponseDTO> getAllSuppliers();
    SupplierResponseDTO getSupplierById(Long id);
    SupplierResponseDTO updateSupplier(Long id,SupplierRequestDTO requestDTO);
    void deleteSupplierById(Long id);
}
