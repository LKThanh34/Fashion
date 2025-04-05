package com.lekimthanh.fashion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lekimthanh.fashion.entity.Category;
import com.lekimthanh.fashion.service.CategoryService;

@Controller
@RequestMapping("/admin/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    // Hiển thị danh sách categories
    @GetMapping
    public String listCategories(Model model) {
        model.addAttribute("categories", categoryService.getAllCategories());
        return "admin/categories/list";
    }

    // Hiển thị form tạo mới
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("category", new Category());
        return "admin/categories/create";
    }

    // Xử lý tạo mới category
    @PostMapping
    public String createCategory(@ModelAttribute Category category) {
        categoryService.saveCategory(category);
        return "redirect:/admin/categories"; // Đúng với mapping của controller
    }

    // Hiển thị form chỉnh sửa
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Category category = categoryService.getCategoryById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid category Id:" + id));
        model.addAttribute("category", category);
        return "admin/categories/edit";
    }

    // Xử lý cập nhật category
    @PostMapping("/update/{id}")
    public String updateCategory(@PathVariable Long id, @ModelAttribute Category category) {
        category.setCategoryId(id);
        categoryService.saveCategory(category);
        return "redirect:/admin/categories"; // Sửa từ /categories thành /admin/categories
    }

    // Xử lý xóa category
    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return "redirect:/admin/categories"; // Sửa từ /categories thành /admin/categories
    }
}