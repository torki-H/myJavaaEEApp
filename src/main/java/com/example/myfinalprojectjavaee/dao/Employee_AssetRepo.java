package com.example.myfinalprojectjavaee.dao;

import com.example.myfinalprojectjavaee.entity.Employee_AssetEntity;
//import com.example.myfinalprojectjavaee.entity.Employee_Asset_PKEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Employee_AssetRepo extends JpaRepository<Employee_AssetEntity,Integer>{//Employee_Asset_PKEntity> {
}
