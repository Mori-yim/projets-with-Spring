package com.labo.Rest.example.projet.service;

import com.labo.Rest.example.projet.model.Customer;

import java.util.List;

public interface CustomerService {


    void create (Customer customer);

    List<Customer> readAll();

    Customer read(int id);

    boolean update(Customer customer, int id);

    boolean delete(int id);
}


