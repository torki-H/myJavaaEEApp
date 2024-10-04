package com.example.myfinalprojectjavaee.service;

import com.example.myfinalprojectjavaee.dao.EmployeeRepo;
import com.example.myfinalprojectjavaee.entity.EmployeeEntity;
import com.example.myfinalprojectjavaee.entity.Employee_AssetEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
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


    public List<EmployeeEntity> getAllEmployeeEntitys() {
        return employeeRepo.findAll();
    }

    public EmployeeEntity saveEmployeeEntity(EmployeeEntity EmployeeEntity) {
        return employeeRepo.save(EmployeeEntity);
    }

    public EmployeeEntity getEmployeeEntityById(int id) {
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
    public List<EmployeeEntity> findAvailableEmployeesForAsset(int assetId){
        return employeeRepo.findAvailableEmployeesForAsset(assetId);
    }


}
