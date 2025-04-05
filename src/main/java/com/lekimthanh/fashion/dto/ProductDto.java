package com.lekimthanh.fashion.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDto {
    private Long productId;
    private String name;
    private String description;
    private Double price;
    private String material;
    private String categoryName; // Tên danh mục
    private Long categoryId; // ID danh mục (dùng cho form)
    private String imageUrl;
    private LocalDateTime createdAt;
    private int variantCount; // Số lượng biến thể
    private int totalStock; // Tổng số lượng tồn kho
    private List<VariantDto> variants; // Danh sách biến thể (nếu cần chi tiết)
}
