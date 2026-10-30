package com.wareflow.service;


import com.wareflow.dto.ProductRequestDTO;
import com.wareflow.dto.ProductResponseDTO;
import com.wareflow.entity.Product;

import java.util.List;

public interface ProductService {
    ProductResponseDTO createProduct(ProductRequestDTO requestDTO);
    ProductResponseDTO getProductById(Long id);
    List<ProductResponseDTO> getAllProducts();
    ProductResponseDTO updateProduct(Long id,ProductRequestDTO request);
    void deleteProduct(Long id);
}
