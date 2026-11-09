package com.wareflow.controller;

import com.wareflow.dto.ProductRequestDTO;
import com.wareflow.dto.ProductResponseDTO;
import com.wareflow.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductResponseDTO> createProduct(@RequestBody @Valid ProductRequestDTO productRequestDTO)
    {
        ProductResponseDTO product = productService.createProduct(productRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> getProductById(@PathVariable Long id)
    {
       ProductResponseDTO productResponseDTO = productService.getProductById(id);
        return ResponseEntity.status(HttpStatus.OK).body(productResponseDTO);
    }


    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> updateProduct(@PathVariable Long id,@RequestBody @Valid ProductRequestDTO productRequestDTO)
    {
        ProductResponseDTO productResponseDTO = productService.updateProduct(id, productRequestDTO);
        return ResponseEntity.status(HttpStatus.OK).body(productResponseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id)
    {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<Page<ProductResponseDTO>> getAllProducts(Pageable pageable)
    {
        return ResponseEntity.ok(productService.getAllProducts(pageable));
    }
    @GetMapping("/search")
    public ResponseEntity<Page<ProductResponseDTO>> searchProductByName(@RequestParam String name,Pageable pageable)
    {
        return ResponseEntity.ok(productService.searchProductByName(name, pageable));
    }
}
