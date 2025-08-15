package com.com.gestion_boutique.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity  //signale une entite

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id //signale  qu'il s'agit de l'id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String label;
    private double price;

}
