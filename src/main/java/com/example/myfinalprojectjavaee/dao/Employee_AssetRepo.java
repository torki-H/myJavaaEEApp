package com.example.myfinalprojectjavaee.dao;

import com.example.myfinalprojectjavaee.entity.EmployeeEntity;
import com.example.myfinalprojectjavaee.entity.Employee_AssetEntity;
//import com.example.myfinalprojectjavaee.entity.Employee_Asset_PKEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Employee_AssetRepo extends JpaRepository<Employee_AssetEntity,Integer>{//Employee_Asset_PKEntity> {

    List<Employee_AssetEntity> findById(int id);

    @Query("SELECT ea FROM employee_asset ea WHERE ea.assetEntity.id = :assetId")
    List<Employee_AssetEntity> findEmployee_AssetEntitiesByAssetId(@Param("assetId") int assetId);

    @Query("SELECT ea FROM employee_asset ea WHERE ea.employeeEntity.Id = :employeeId")
    List<Employee_AssetEntity> findEmployee_AssetEntitiesByEmployeeId(@Param("employeeId") int employeeId);
    @Query("SELECT ea FROM employee_asset ea WHERE ea.assetEntity.id = :assetId and ea.employeeEntity.Id in :employeeId")
    List<Employee_AssetEntity> findEmployee_AssetEntitiesByEmployeeIdAndAssetId(@Param("assetId") int assetId,@Param("employeeId") int employeeId);


    @Query(" SELECT emp_aset FROM " +
            " employee_asset emp_aset " +
            " WHERE emp_aset.assignStatus = true " +
            " AND emp_aset.assetEntity.id = :assetId ")
    List<Employee_AssetEntity> availableEmployeesForUnAssign(@Param("assetId") int assetId);
}
