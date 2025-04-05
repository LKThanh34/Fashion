package com.lekimthanh.fashion.repository;

import com.lekimthanh.fashion.entity.ProductVariant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VariantRepository extends JpaRepository<ProductVariant, Long> {
    List<ProductVariant> findByProductProductId(Long productId);
}