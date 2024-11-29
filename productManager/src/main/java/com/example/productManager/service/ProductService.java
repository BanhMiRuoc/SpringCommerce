package com.example.productManager.service;

import com.example.productManager.exception.ProductNotFoundException;
import com.example.productManager.model.Product;
import com.example.productManager.repository.ProductRepository;
import jdk.jfr.Category;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product getById(Integer id) {
        return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product with ID: " + id + " not found"));
    }
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public long count() {
        return productRepository.count();
    }

    public boolean deleteById(Integer id) {
        Product product = productRepository.findById(id).orElse(null);
        if (product != null) {
            productRepository.delete(product);
            return true;
        }
        return false;
    }

    public void delete(Product product1) {
        productRepository.delete(product1);
    }

    public void deleteAll() {
        productRepository.deleteAll();
    }
    public Product update(int id, Product product) {
        Product product1 = productRepository.findById(id).orElse(null);
        if (product1 != null) {
            product1.setName(product.getName());
            product1.setCategory(product.getCategory());
            product1.setPrice(product.getPrice());
            product1.setBrand(product.getBrand());
            product1.setColor(product.getColor());
            product1.setDescription(product.getDescription());
            return productRepository.save(product);
        }
        return null;
    }
    public Product add(Product product) {
        return productRepository.save(product);
    }
    public List<Product> findByCategory(String category) {
        return productRepository.findByCategory(category);
    }
}
