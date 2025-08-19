package com.example.crud_springboot.repository;

import com.example.crud_springboot.entity.Employers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Employersrepository extends JpaRepository<Employers,Long> {

}
