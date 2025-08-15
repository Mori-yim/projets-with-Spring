package com.labo.Rest.example.projet.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Customer {
    private Integer id;
    private String name;
    private String email;
    private String phone;

    public void setId(int id) {
        this.id=id;
    }
}
