package com.example.myfinalprojectjavaee.dao;

import com.example.myfinalprojectjavaee.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository<CategoryEntity,Integer> {

}
