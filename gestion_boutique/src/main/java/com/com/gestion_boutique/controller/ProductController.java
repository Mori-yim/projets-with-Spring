package com.com.gestion_boutique.controller;

import com.com.gestion_boutique.entity.Product;
import com.com.gestion_boutique.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/product")

public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/create")
    public ResponseEntity<Product> create(@RequestBody Product product){
        productService.create(product);
        return ResponseEntity.ok(product);
    }

    @GetMapping("/")
    public List<Product> getAllProduct(){
        return productService.getAllProduct();
    }

    @GetMapping("/{id}")
    public  ResponseEntity<Product> getById(@PathVariable Long id){
        Optional<Product> optionalProduct = productService.getProductById(id);
        return optionalProduct.map(ResponseEntity::ok).orElseGet(()->
                ResponseEntity.noContent().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        if (productService.existById(id)){
            productService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        else
            return ResponseEntity.notFound().build();
    }

    @PutMapping(value = "/modify/{id}", consumes = "application/json")
    public ResponseEntity<Product> updateProduct(
            @PathVariable Long id,
            @RequestBody Product productDetails) {

        Product updatedProduct = productService.updateProductById(id, productDetails);
        return ResponseEntity.ok(updatedProduct);
    }

}
