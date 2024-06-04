package com.example.inventorymanagementsystem.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public void editProduct(Long id, Product editedProduct) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid product ID: " + id));
        existingProduct.setName(editedProduct.getName());
        existingProduct.setType(editedProduct.getType());
        existingProduct.setPrice(editedProduct.getPrice());
        existingProduct.setQty(editedProduct.getQty());
        productRepository.save(existingProduct);
    }
}
