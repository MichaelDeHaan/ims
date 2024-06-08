package com.example.inventorymanagementsystem.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    String home(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        model.addAttribute("productCount", productService.getTotalProducts());
        model.addAttribute("outOfStockProducts", productService.getOutOfStockProducts());
        model.addAttribute("lowStockProducts", productService.getLowStockProducts(10));
        model.addAttribute("product", new Product());
        return "index";
    }

    @PostMapping("/product")
    String newProduct(@ModelAttribute Product newProduct) {
        productService.save(newProduct);
        return "redirect:/";
    }

    @PostMapping("/product/{id}")
    String editProduct(@PathVariable("id") Long id, @ModelAttribute Product editedProduct) {
        productService.editProduct(id, editedProduct);
        return "redirect:/";
    }

    @DeleteMapping("/product/{id}")
    public String deleteProduct(@PathVariable("id") Long id) {
        productService.deleteById(id);
        return "redirect:/";
    }
}
