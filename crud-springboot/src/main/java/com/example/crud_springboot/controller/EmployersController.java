package com.example.crud_springboot.controller;

import com.example.crud_springboot.entity.Employers;
import com.example.crud_springboot.service.EmployersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employers")
public class EmployersController {
    @Autowired
    private EmployersService employersService;
    
    @PostMapping ("/create")
    public ResponseEntity<Employers> create(@RequestBody Employers employers){
        return  new ResponseEntity<>(employersService.createEmployers(employers), HttpStatus.CREATED);
    }
    
    @GetMapping ("/")
    public List<Employers> getAll(){
        return employersService.getAllEmployers();
    }
    
    @GetMapping ("/{id}")
    public ResponseEntity<Optional<Employers>> getById(@PathVariable Long id){
        return new ResponseEntity<>(employersService.getEmployersById(id),HttpStatus.OK);
    }
    
    @PutMapping ("/update/{id}")
    public ResponseEntity<Employers> updateByid(@PathVariable Long id, @RequestBody Employers employers){
        return new ResponseEntity<>(employersService.updateEmployersById(id,employers),HttpStatus.OK);
    }
    
    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        employersService.deleteEmployersById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
