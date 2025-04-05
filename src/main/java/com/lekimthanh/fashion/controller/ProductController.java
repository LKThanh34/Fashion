// ProductController.java
package com.lekimthanh.fashion.controller;

import com.lekimthanh.fashion.entity.Product;
import com.lekimthanh.fashion.service.CategoryService;
import com.lekimthanh.fashion.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    // Hiển thị danh sách sản phẩm
    @GetMapping
    public String listProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "admin/products/list";
    }

    // Hiển thị form tạo sản phẩm mới
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("categories", categoryService.getAllCategories());
        return "admin/products/create";
    }

    // Xử lý tạo sản phẩm mới
    @PostMapping
    public String createProduct(@ModelAttribute Product product) {
        productService.saveProduct(product);
        return "redirect:/admin/products";
    }

    // Hiển thị form chỉnh sửa sản phẩm
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Product product = productService.getProductById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid product Id: " + id));
        model.addAttribute("product", product);
        model.addAttribute("categories", categoryService.getAllCategories());
        return "admin/products/edit";
    }

    // Xử lý cập nhật sản phẩm
    @PostMapping("/update/{id}")
    public String updateProduct(@PathVariable Long id, @ModelAttribute Product product) {
        product.setProductId(id); // Đảm bảo cập nhật đúng sản phẩm
        productService.saveProduct(product);
        return "redirect:/admin/products";
    }

    // Xử lý xóa sản phẩm
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "redirect:/admin/products";
    }
}