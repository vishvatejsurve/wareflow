package com.wareflow.service;

import com.wareflow.dto.SupplierRequestDTO;
import com.wareflow.dto.SupplierResponseDTO;
import com.wareflow.entity.Supplier;
import com.wareflow.mapper.SupplierMapper;
import com.wareflow.repository.SupplierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SupplierServiceImpl implements SupplierService{

    private final SupplierRepository supplierRepository;
    private final SupplierMapper supplierMapper;


    @Override
    public SupplierResponseDTO createSupplier(SupplierRequestDTO supplierRequestDTO) {
        Supplier entity = supplierMapper.toEntity(supplierRequestDTO);
        Supplier savedSupplier = supplierRepository.save(entity);
        return supplierMapper.toResponse(savedSupplier);
    }

    @Override
    public List<SupplierResponseDTO> getAllSuppliers() {


        return supplierRepository.findAll()
                .stream()
                .map(supplierMapper::toResponse)
                .toList();
    }

    @Override
    public SupplierResponseDTO getSupplierById(Long id) {
        Supplier supplier = supplierRepository.findById(id).orElseThrow(() -> new RuntimeException("Supplier is not found"));
        return supplierMapper.toResponse(supplier);
    }

    @Override
    public SupplierResponseDTO updateSupplier(Long id, SupplierRequestDTO requestDTO) {
        Supplier supplier = supplierRepository.findById(id).orElseThrow(() -> new RuntimeException("Supplier is not found"));
        supplier.setName(requestDTO.getName());
        supplier.setEmail(requestDTO.getEmail());
        supplier.setPhone(requestDTO.getPhone());

        supplierRepository.save(supplier);
        return supplierMapper.toResponse(supplier);
    }

    @Override
    public void deleteSupplierById(Long id) {
       Supplier supplier = supplierRepository.findById(id).orElseThrow(()->new RuntimeException("Supplier is not found"));
       supplierRepository.delete(supplier);
    }
}
