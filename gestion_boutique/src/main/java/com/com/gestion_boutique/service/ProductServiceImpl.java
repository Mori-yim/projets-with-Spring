package com.com.gestion_boutique.service;

import com.com.gestion_boutique.entity.Product;
import com.com.gestion_boutique.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    public ProductRepository productRepository;
    @Override
    public void create(Product product) {
       productRepository.save(product);
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public boolean existById(Long id) {
        return productRepository.existsById(id);
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product updateProductById(Long id, Product productDetails) {
        // 1️ Recherche du produit existant
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produit non trouvé avec id : " + id));

        // 2️ Mise à jour des champs
        product.setLabel(productDetails.getLabel());
        product.setPrice(productDetails.getPrice());

        // 3️ Sauvegarde dans la base
        return productRepository.save(product);
    }
}
