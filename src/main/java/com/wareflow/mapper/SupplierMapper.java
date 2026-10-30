package com.wareflow.mapper;

import com.wareflow.dto.SupplierRequestDTO;
import com.wareflow.dto.SupplierResponseDTO;
import com.wareflow.entity.Supplier;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SupplierMapper {

    Supplier toEntity(SupplierRequestDTO requestDTO);

    SupplierResponseDTO toResponse(Supplier supplier);
}
