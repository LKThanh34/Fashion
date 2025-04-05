package com.lekimthanh.fashion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lekimthanh.fashion.entity.Product;
import com.lekimthanh.fashion.entity.ProductVariant;
import com.lekimthanh.fashion.service.ProductService;
import com.lekimthanh.fashion.service.VariantService;

@Controller
@RequestMapping("/admin/variants")
public class VariantController {

    @Autowired
    private VariantService variantService;

    @Autowired
    private ProductService productService;

    // Hiển thị danh sách biến thể của một sản phẩm
    @GetMapping("/product/{productId}")
    public String listVariants(@PathVariable Long productId, Model model) {
        Product product = productService.getProductById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid product Id: " + productId));
        model.addAttribute("product", product);
        model.addAttribute("variants", variantService.getVariantsByProductId(productId));
        return "admin/variants/list";
    }

    // Hiển thị form tạo biến thể mới
    @GetMapping("/new/{productId}")
    public String showCreateForm(@PathVariable Long productId, Model model) {
        Product product = productService.getProductById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid product Id: " + productId));
        ProductVariant variant = new ProductVariant();
        variant.setProduct(product); // Liên kết với sản phẩm
        model.addAttribute("variant", variant);
        model.addAttribute("product", product);
        return "admin/variants/create";
    }

    // Xử lý tạo biến thể mới
    @PostMapping("/new/{productId}")
    public String createVariant(@PathVariable Long productId, @ModelAttribute ProductVariant variant) {
        Product product = productService.getProductById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid product Id: " + productId));
        variant.setProduct(product); // Đảm bảo variant thuộc về product
        variantService.saveVariant(variant);
        return "redirect:/admin/variants/product/" + productId;
    }

    // Hiển thị form chỉnh sửa biến thể
    @GetMapping("/edit/{variantId}")
    public String showEditForm(@PathVariable Long variantId, Model model) {
        ProductVariant variant = variantService.getVariantById(variantId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid variant Id: " + variantId));
        model.addAttribute("variant", variant);
        model.addAttribute("product", variant.getProduct());
        return "admin/variants/edit";
    }

    // Xử lý cập nhật biến thể
    @PostMapping("/update/{variantId}")
    public String updateVariant(@PathVariable Long variantId, @ModelAttribute ProductVariant variant) {
        ProductVariant existingVariant = variantService.getVariantById(variantId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid variant Id: " + variantId));
        variant.setVariantId(variantId); // Đảm bảo cập nhật đúng variant
        variant.setProduct(existingVariant.getProduct()); // Giữ nguyên product
        variantService.saveVariant(variant);
        return "redirect:/admin/variants/product/" + existingVariant.getProduct().getProductId();
    }

    // Xử lý xóa biến thể
    @GetMapping("/delete/{variantId}")
    public String deleteVariant(@PathVariable Long variantId) {
        ProductVariant variant = variantService.getVariantById(variantId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid variant Id: " + variantId));
        Long productId = variant.getProduct().getProductId();
        variantService.deleteVariant(variantId);
        return "redirect:/admin/variants/product/" + productId;
    }

}
