package com.wareflow.service;


import com.wareflow.dto.ProductRequestDTO;
import com.wareflow.dto.ProductResponseDTO;
import com.wareflow.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    ProductResponseDTO createProduct(ProductRequestDTO requestDTO);
    ProductResponseDTO getProductById(Long id);
    List<ProductResponseDTO> getAllProducts();
    ProductResponseDTO updateProduct(Long id,ProductRequestDTO request);
    void deleteProduct(Long id);
    Page<ProductResponseDTO> getAllProducts(Pageable pageable);
    Page<ProductResponseDTO> searchProductByName(String name,Pageable pageable);

}
