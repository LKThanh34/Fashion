package com.lekimthanh.fashion.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "promotions")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long promoId;

    private String code;

    @Enumerated(EnumType.STRING)
    private DiscountType discountType;

    private Double discountValue;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Double minOrderAmount;
}

enum DiscountType {
    PERCENT, FIXED
}
