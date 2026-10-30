package com.wareflow.service;

import com.wareflow.dto.ProductRequestDTO;
import com.wareflow.dto.ProductResponseDTO;
import com.wareflow.entity.Product;
import com.wareflow.entity.Supplier;
import com.wareflow.mapper.ProductMapper;
import com.wareflow.repository.ProductRepository;
import com.wareflow.repository.SupplierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;
    private final SupplierRepository supplierRepository;
    private final ProductMapper mapper;

    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO requestDTO) {
        Product product= mapper.toEntity(requestDTO);
        Supplier supplier = supplierRepository.findById(requestDTO.getSupplierId())
                .orElseThrow(() -> new RuntimeException("Supplier not found"));

        product.setSupplier(supplier);

        Product savedProduct = productRepository.save(product);

      return mapper.toResponseDto(savedProduct);
    }

    @Override
    public ProductResponseDTO getProductById(Long id) {
        Product product= productRepository.findById(id).orElseThrow(()->new RuntimeException("Product not found"));
        return mapper.toResponseDto(product);
    }

    @Override
    public List<ProductResponseDTO> getAllProducts() {
        return  productRepository.findAll()
                .stream()
                .map(mapper::toResponseDto)
                .toList();
    }

    @Override
    public ProductResponseDTO updateProduct(Long id, ProductRequestDTO request) {
        Product product = productRepository.findById(id).orElseThrow();


        product.setSku(request.getSku());
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setQuantity(request.getQuantity());
        product.setReorderLevel(request.getReorderLevel());
        Supplier supplier = supplierRepository.findById(request.getSupplierId()).orElseThrow(()->new RuntimeException("Supplier not found"));
        product.setSupplier(supplier);

        Product updatedProduct = productRepository.save(product);

        return mapper.toResponseDto(updatedProduct);
    }

    @Override
    public void deleteProduct(Long id) {
            Product product = productRepository.findById(id).orElseThrow(()->new RuntimeException("Product not found"));
            productRepository.delete(product);
    }
}
