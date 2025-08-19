package com.example.crud_springboot.service;

import com.example.crud_springboot.entity.Employers;

import java.util.List;
import java.util.Optional;

public interface EmployersService {
    public Employers createEmployers(Employers employers);
    public List<Employers> getAllEmployers();
    public Optional<Employers> getEmployersById(Long id);
    public Employers updateEmployersById(Long id, Employers employers);
    public void deleteEmployersById(Long id);
}
