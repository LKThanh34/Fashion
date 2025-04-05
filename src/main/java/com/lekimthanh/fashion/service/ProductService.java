package com.lekimthanh.fashion.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lekimthanh.fashion.entity.Product;
import com.lekimthanh.fashion.entity.ProductVariant;
import com.lekimthanh.fashion.repository.ProductRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public Product saveProduct(Product product) {
        if (product.getProductId() == null) {
            product.setCreatedAt(LocalDateTime.now());
        }
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    // Tính số lượng biến thể
    public int getVariantCount(Product product) {
        List<ProductVariant> variants = product.getVariants();
        return variants != null ? variants.size() : 0;
    }

    // Tính tổng stock
    public int getTotalStock(Product product) {
        List<ProductVariant> variants = product.getVariants();
        if (variants == null || variants.isEmpty()) {
            return 0;
        }
        return variants.stream()
                .filter(v -> v.getStock() != null) // Tránh NullPointerException
                .mapToInt(ProductVariant::getStock)
                .sum();
    }
}
