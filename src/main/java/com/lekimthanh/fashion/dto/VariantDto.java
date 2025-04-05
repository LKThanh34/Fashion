package com.lekimthanh.fashion.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VariantDto {
    private Long variantId;
    private String size;
    private String color;
    private Integer stock;
    private Double priceModifier;
}
