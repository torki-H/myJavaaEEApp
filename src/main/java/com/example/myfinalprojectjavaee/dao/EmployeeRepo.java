package com.example.myfinalprojectjavaee.dao;

import com.example.myfinalprojectjavaee.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface EmployeeRepo extends JpaRepository<EmployeeEntity,Integer> {
    List<EmployeeEntity> findAllByNameAndFamily(String name,String family);

    List<EmployeeEntity> findByNameLike(String name);



}
