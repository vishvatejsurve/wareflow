package com.wareflow.controller;

import com.wareflow.dto.SupplierRequestDTO;
import com.wareflow.dto.SupplierResponseDTO;
import com.wareflow.service.SupplierService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/suppliers")
@RequiredArgsConstructor
public class SupplierController {
    private final SupplierService supplierService;

    @PostMapping
    public ResponseEntity<SupplierResponseDTO> createSupplier(@RequestBody @Valid  SupplierRequestDTO requestDTO)
    {
        SupplierResponseDTO supplier = supplierService.createSupplier(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(supplier);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SupplierResponseDTO> getSupplierById(@PathVariable Long id)
    {
        SupplierResponseDTO supplierById = supplierService.getSupplierById(id);
        return ResponseEntity.status(HttpStatus.OK).body(supplierById);
    }

    @GetMapping
    public ResponseEntity<List<SupplierResponseDTO>> getAllSupplier()
    {
        List<SupplierResponseDTO> allSuppliers = supplierService.getAllSuppliers();
        return ResponseEntity.status(HttpStatus.OK).body(allSuppliers);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SupplierResponseDTO> updateSupplier(@PathVariable Long id,@RequestBody @Valid SupplierRequestDTO supplierRequestDTO)
    {
        SupplierResponseDTO supplierResponseDTO = supplierService.updateSupplier(id, supplierRequestDTO);

        return ResponseEntity.status(HttpStatus.OK).body(supplierResponseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSupplier(@PathVariable Long id)
    {
        supplierService.deleteSupplierById(id);
        return ResponseEntity.noContent().build();
    }
}
