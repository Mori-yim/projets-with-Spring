package com.com.gestion_boutique.repository;

import com.com.gestion_boutique.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {


}
