package com.example.myfinalprojectjavaee.controller;

import com.example.myfinalprojectjavaee.entity.CategoryEntity;

import com.example.myfinalprojectjavaee.service.CategoryService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller

public class CategoryController {
    private CategoryService categoryService;


    public CategoryController(CategoryService categoryService) {
        super();
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public String listOfCategories(Model model) {
        model.addAttribute("categories",categoryService.getAllCategories());
        return "category/categories";
    }

    @GetMapping("/categories/new")
    public String createCategory(Model model) {
        CategoryEntity categoryEntity =new CategoryEntity();
        model.addAttribute("categories", categoryEntity);
        return "category/create_category";

    }

    @PostMapping("/categories")
    public String saveCategory(@ModelAttribute("categories") CategoryEntity categoryEntity) {
        categoryService.saveCategory(categoryEntity);
        return "redirect:/categories";
    }

    @GetMapping("/categories/edit/{id}")
    public String editCategoryForm(@PathVariable int id, Model model) {
        model.addAttribute("category", categoryService.getCategoryEntityById(id));
        return "category/edit_category";
    }

    @PostMapping("/categories/{id}")
    public String updateStudent(@PathVariable int id,
                                @ModelAttribute("category") CategoryEntity categoryEntity) {
        CategoryEntity existingcategory = categoryService.getCategoryEntityById(id);
        existingcategory.setId(id);
        existingcategory.setDescription(categoryEntity.getDescription());
        categoryService.updateEmployeeEntity(existingcategory);
        return "redirect:/categories";
    }


    @GetMapping("/categories/{id}")
    public String deleteCategory(@PathVariable int id) {
        categoryService.deleteCategoryEntityById(id);
        return "redirect:/categories";
    }


}
