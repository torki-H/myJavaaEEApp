package com.example.myfinalprojectjavaee.dao;

import com.example.myfinalprojectjavaee.entity.EmployeeEntity;
import com.example.myfinalprojectjavaee.entity.Employee_AssetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface EmployeeRepo extends JpaRepository<EmployeeEntity,Integer> {
    List<EmployeeEntity> findAllByNameAndFamily(String name,String family);

    List<EmployeeEntity> findByNameLike(String name);

    EmployeeEntity findEmployeeEntityById(int id);



//    @Query("SELECT emp FROM employee emp " +
//            "LEFT JOIN employee_asset emp_asset ON emp.Id = emp_asset.employeeEntity.Id " +
//            "WHERE (emp_asset.assetEntity.id != :assetId OR emp_asset.assetEntity.id IS NULL) " +
//            "AND (emp_asset.assignStatus IS NULL OR emp_asset.assignStatus = false)")
//    List<EmployeeEntity> findAvailableEmployeesForAsset(@Param("assetId") int assetId);

    @Query(" SELECT emp FROM employee emp" +
            " LEFT JOIN employee_asset emp_aset" +
            " ON emp.Id = emp_aset.employeeEntity.Id" +
            " AND emp_aset.assetEntity.id = :assetId " +
            "WHERE emp_aset.assignStatus IS NULL " +
            "OR emp_aset.assignStatus = false"  )
    List<EmployeeEntity> findAvailableEmployeesForAsset(@Param("assetId") int assetId);

}
