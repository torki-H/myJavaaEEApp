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

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class Employee_AssetService {

//    @Autowired
//    private AssetRepo assetRepo;
//
//    @Autowired
//    private EmployeeRepo employeeRepo;
//    @Autowired
//    //private EmployeeAssetEntityRepository employeeAssetEntityRepository;
//    private Employee_AssetRepo employeeAssetRepo;
//
//    public void assignAssetToEmployee(int assetId, int employeeId) {
//        saveAssignAssetToEmployee(assetId, employeeId);
//    }
//
//    public void saveAssignAssetToEmployee(int assetId, int employeeId) {
//        Employee_AssetEntity assignment=new Employee_AssetEntity();
//
//        EmployeeEntity employee = employeeRepo.findById(employeeId).orElseThrow(EntityNotFoundException::new);
//        AssetEntity asset = assetRepo.findById(assetId).orElseThrow(EntityNotFoundException::new);
//
//        assignment.setEmployeeEntity(employee);
//        assignment.setAssetEntity(asset);
//
//        employeeAssetRepo.save(assignment);
//    }

    @Autowired
    private Employee_AssetRepo employeeAssetRepo;
    @Autowired
    private AssetRepo assetRepo;

    @Autowired
    private EmployeeRepo employeeRepo;

//    public void assignEmployeeToAsset(int assetId, List<Integer> employeeIds) {
//        AssetEntity asset = assetRepo.findById(assetId)
//                .orElseThrow(() -> new EntityNotFoundException("دارایی با ID " + assetId + " پیدا نشد."));
//        employeeIds.forEach(employeeId -> {
//            EmployeeEntity employee = employeeRepo.findById(employeeId)
//                    .orElseThrow(() -> new EntityNotFoundException("کارمند با ID " + employeeId + " پیدا نشد."));
//            Employee_AssetEntity assignment = new Employee_AssetEntity();
//            assignment.setEmployeeEntity(employee);
//            assignment.setAssetEntity(asset);
//            employeeAssetRepo.save(assignment);
//        });
//    }




    public void assignEmployeeToAsset(int assetId, List<Integer> employeeIds) {
        List<Employee_AssetEntity> allEmployeeAssets = employeeAssetRepo.findAll();

        // ساخت یک Set برای دسترسی سریع به شناسه‌های کارمندان موجود
        Set<Integer> assignedEmployeeIds = new HashSet<>();
        for (Employee_AssetEntity employeeAsst : allEmployeeAssets) {
            assignedEmployeeIds.add(employeeAsst.getEmployeeEntity().getId());
        }

        // بررسی و تفکیک کارمندانی که می‌توانند به دارایی اختصاص یابند
        AssetEntity asset = assetRepo.findById(assetId)
                .orElseThrow(() -> new EntityNotFoundException("دارایی با ID " + assetId + " پیدا نشد."));

        for (int employeeId : employeeIds) {
            if (assignedEmployeeIds.contains(employeeId)) {
                System.out.println("این کارمند با ID " + employeeId + " به دارایی اختصاص داده شده است.");
            } else {
                EmployeeEntity employee = employeeRepo.findById(employeeId)
                        .orElseThrow(() -> new EntityNotFoundException("کارمند با ID " + employeeId + " پیدا نشد."));
                Employee_AssetEntity assignment = new Employee_AssetEntity();
                assignment.setEmployeeEntity(employee);
                assignment.setAssetEntity(asset);
                employeeAssetRepo.save(assignment);
            }
        }
    }

    public void unAssignEmployeeFromAsset(int assetId, List<Integer> employeeIds) {
        for (int employeeId : employeeIds) {

            List<Employee_AssetEntity> employeeAssetEntities = employeeAssetRepo.findEmployee_AssetEntitiesByEmployeeIdAndAssetId(assetId, employeeId);
            if (!employeeAssetEntities.isEmpty()) {
                employeeAssetRepo.deleteAll(employeeAssetEntities);
            }
        }
    }



//    public void assignEmployeeToAsset(int assetId, List<Integer> employeeIds) {
//        List<Employee_AssetEntity> allEmployeeAssets = employeeAssetRepo.findAll();
//        for (int i = 0; i < employeeIds.size(); i++) {
//            for (Employee_AssetEntity employeeAsst : allEmployeeAssets) {
//                for (int empId : employeeIds) {
//                    if (employeeIds.get(i).equals(allEmployeeAssets.get(i).getEmployeeEntity().getId()) &&
//                            allEmployeeAssets.get(i).getAssetEntity().getId() == assetId)
//                        System.out.println(" this employee assigned");
//                    else {
//                        AssetEntity asset = assetRepo.findById(assetId)
//                                .orElseThrow(() -> new EntityNotFoundException("دارایی با ID " + assetId + " پیدا نشد."));
//                        employeeIds.forEach(employeeId -> {
//                            EmployeeEntity employee = employeeRepo.findById(employeeId)
//                                    .orElseThrow(() -> new EntityNotFoundException("کارمند با ID " + employeeId + " پیدا نشد."));
//                            Employee_AssetEntity assignment = new Employee_AssetEntity();
//                            assignment.setEmployeeEntity(employee);
//                            assignment.setAssetEntity(asset);
//                            employeeAssetRepo.save(assignment);
//                        });
//
//
//                    }
//                }
//
//            }
//
//        }
//
//    }

    public List<Employee_AssetEntity> findAll() {
        return employeeAssetRepo.findAll();
    }

    public List<Employee_AssetEntity> findEmployeeAssetById(int id) {
        return employeeAssetRepo.findAllById(Collections.singleton(id));
    }

//    public List<Project> getProjectsByEmployeeId(Long employeeId) {
//        List<EmployeeProject> employeeProjects = employeeProjectRepository.findProjectsByEmployeeId(employeeId);
//        return employeeProjects.stream()
//                .map(ep -> ep.getProject()) // فرض که متد getProject() در EmployeeProject تعریف شده باشد
//                .collect(Collectors.toList());
//    }

    public List<Employee_AssetEntity> getEmployee_AssetEntitiesByAssetId(int assetId) {
        return employeeAssetRepo.findEmployee_AssetEntitiesByAssetId(assetId);
    }
}
