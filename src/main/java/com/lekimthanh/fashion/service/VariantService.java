package com.lekimthanh.fashion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lekimthanh.fashion.entity.Product;
import com.lekimthanh.fashion.entity.ProductVariant;
import com.lekimthanh.fashion.repository.VariantRepository;

import java.util.List;
import java.util.Optional;

@Service
public class VariantService {
    @Autowired
    private VariantRepository variantRepository;

    public List<ProductVariant> getVariantsByProductId(Long productId) {
        return variantRepository.findByProductProductId(productId);
    }

    public Optional<ProductVariant> getVariantById(Long id) {
        return variantRepository.findById(id);
    }

    public ProductVariant saveVariant(ProductVariant variant) {
        return variantRepository.save(variant);
    }

    public void deleteVariant(Long id) {
        variantRepository.deleteById(id);
    }

}
