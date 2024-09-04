package com.example.myfinalprojectjavaee.service;

import com.example.myfinalprojectjavaee.dao.CategoryRepo;
import com.example.myfinalprojectjavaee.entity.CategoryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private CategoryRepo categoryRepo;

    @Autowired
    public CategoryService(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }


    public CategoryEntity getCategoryById(int id) {
        Optional<CategoryEntity> optionalCategory = categoryRepo.findById(id);
        return optionalCategory.orElse(null);
    }

    public CategoryEntity saveCategory(CategoryEntity category) {
        return categoryRepo.save(category);
    }

    public void deleteCategory(int id) {
        categoryRepo.deleteById(id);
    }

    public List<CategoryEntity> getAllCategories() {
        return categoryRepo.findAll();
    }

    public CategoryEntity getCategoryEntityById(int id) {
        return categoryRepo.findCategoryEntityById(id);
    }


    public CategoryEntity updateEmployeeEntity(CategoryEntity categoryEntity) {
        return categoryRepo.save(categoryEntity);
    }

    public void deleteCategoryEntityById(int id) {
        categoryRepo.deleteById(id);
    }

}
