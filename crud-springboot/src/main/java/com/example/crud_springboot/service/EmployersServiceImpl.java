package com.example.crud_springboot.service;

import com.example.crud_springboot.entity.Employers;
import com.example.crud_springboot.repository.Employersrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployersServiceImpl implements EmployersService {
    @Autowired
    private Employersrepository  employersrepository;

    @Override
    public Employers createEmployers(Employers employers) {
        return employersrepository.save(employers);
    }

    @Override
    public List<Employers> getAllEmployers() {
        return employersrepository.findAll();
    }

    @Override
    public Optional<Employers> getEmployersById(Long id) {
        return employersrepository.findById(id);
    }

    @Override
//    public Employers updateEmployersById(Long id, Employers employers) {
//        Optional<Employers> existingEmployers = employersrepository.findById(id);
//        if (existingEmployers.isPresent()) {
//            Employers modifyEmployers = existingEmployers.get();
//            modifyEmployers.setId(employers.getId());
//            modifyEmployers.setName(employers.getName());
//            modifyEmployers.setSpecialisation(employers.getSpecialisation());
//            modifyEmployers.setAge(employers.getAge());
//            modifyEmployers.setSalaire(employers.getSalaire());
//            modifyEmployers.setEmail(employers.getEmail());
//            return employersrepository.save(modifyEmployers);
//        }
//
//        return null;
//    }
    public Employers updateEmployersById(Long id, Employers employers) {
        Optional<Employers> existingEmployers = employersrepository.findById(id);
        if (existingEmployers.isPresent()) {
            Employers modifyEmployers = existingEmployers.get();
            modifyEmployers.setName(employers.getName());
            modifyEmployers.setSpecialisation(employers.getSpecialisation());
            modifyEmployers.setAge(employers.getAge());
            modifyEmployers.setSalaire(employers.getSalaire());
            modifyEmployers.setEmail(employers.getEmail());
            return employersrepository.save(modifyEmployers);
        } else {
            throw new RuntimeException("Employé non trouvé avec l'id " + id);
        }
    }


    @Override
    public void deleteEmployersById(Long id) {
      employersrepository.deleteById(id);
    }
}
