package com.example.myfinalprojectjavaee.service;

import com.example.myfinalprojectjavaee.dao.AssetRepo;
import com.example.myfinalprojectjavaee.dao.EmployeeRepo;
import com.example.myfinalprojectjavaee.dao.Employee_AssetRepo;
import com.example.myfinalprojectjavaee.entity.AssetEntity;
import com.example.myfinalprojectjavaee.entity.EmployeeEntity;
import com.example.myfinalprojectjavaee.entity.Employee_AssetEntity;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Employee_AssetService {

    @Autowired
    private AssetRepo assetRepo;

    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    //private EmployeeAssetEntityRepository employeeAssetEntityRepository;
    private Employee_AssetRepo employeeAssetRepo;

    public void assignAssetToEmployee(int assetId, int employeeId) {
        saveAssignAssetToEmployee(assetId, employeeId);
    }

    public void saveAssignAssetToEmployee(int assetId, int employeeId) {
        Employee_AssetEntity assignment=new Employee_AssetEntity();

        EmployeeEntity employee = employeeRepo.findById(employeeId).orElseThrow(EntityNotFoundException::new);
        AssetEntity asset = assetRepo.findById(assetId).orElseThrow(EntityNotFoundException::new);

        assignment.setEmployeeEntity(employee);
        assignment.setAssetEntity(asset);

        employeeAssetRepo.save(assignment);
    }

}
