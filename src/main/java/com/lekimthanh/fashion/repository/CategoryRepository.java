package com.lekimthanh.fashion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lekimthanh.fashion.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    
}
