package com.example.myfinalprojectjavaee.service;

import com.example.myfinalprojectjavaee.dao.EmployeeRepo;
import com.example.myfinalprojectjavaee.entity.EmployeeEntity;
import com.example.myfinalprojectjavaee.entity.Employee_AssetEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;
    public List<EmployeeEntity> getAllEmployees(){

       return employeeRepo.findAll();
    }

    public List<EmployeeEntity> searchByNameAndFamily(String name,String family){
        return employeeRepo.findAllByNameAndFamily(name,family);
    }

    public boolean addOne(EmployeeEntity employeeEntity) {
        try {
            employeeRepo.save(employeeEntity);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean editOne(EmployeeEntity employeeEntity) {
        try {
            employeeRepo.save(employeeEntity);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public boolean deleteOne(int id) {
        try {
            employeeRepo.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<EmployeeEntity> getAll(){
        return employeeRepo.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

//    public Optional<EmployeeEntity> getOne(int id){
//        return employeeRepo.findById(id);
//    }











    
    
    
    
    
    
    
    
    
    
    
    
    
    

    public List<EmployeeEntity> getAllEmployeeEntitys() {
        return employeeRepo.findAll();
    }

    public EmployeeEntity saveEmployeeEntity(EmployeeEntity EmployeeEntity) {
        return employeeRepo.save(EmployeeEntity);
    }

    public EmployeeEntity getEmployeeEntityById(int id) {
        //return employeeRepo.findById(id).get();
        return employeeRepo.findEmployeeEntityById(id);
    }

    public EmployeeEntity updateEmployeeEntity(EmployeeEntity EmployeeEntity) {
        return employeeRepo.save(EmployeeEntity);
    }

    public void deleteEmployeeEntityById(int id) {
        employeeRepo.deleteById(id);
    }

    public List<EmployeeEntity> searchEmployees(String name){
        return employeeRepo.findByNameLike("%" + name + "%");

    }

}
