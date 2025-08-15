package com.com.gestion_boutique.service;

import com.com.gestion_boutique.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    public void create(Product product);
    public List<Product> getAllProduct();
    public Optional<Product> getProductById(Long id);
    public boolean existById(Long id);
    public void deleteById(Long id);
    public Product updateProductById(Long id, Product product);
}
