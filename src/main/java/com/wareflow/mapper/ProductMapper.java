package com.wareflow.mapper;

import com.wareflow.dto.ProductRequestDTO;
import com.wareflow.dto.ProductResponseDTO;
import com.wareflow.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface ProductMapper {

   Product toEntity(ProductRequestDTO requestDTO);

   @Mapping(source = "supplier.id",target = "supplierId")
   ProductResponseDTO toResponseDto(Product product);
}
