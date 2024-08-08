package com.example.myfinalprojectjavaee.controller;

import com.example.myfinalprojectjavaee.entity.AssetEntity;
import com.example.myfinalprojectjavaee.entity.CategoryEntity;
import com.example.myfinalprojectjavaee.entity.EmployeeEntity;
import com.example.myfinalprojectjavaee.entity.Employee_AssetEntity;
import com.example.myfinalprojectjavaee.service.AssetService;
import com.example.myfinalprojectjavaee.service.CategoryService;
import com.example.myfinalprojectjavaee.service.EmployeeService;
import com.example.myfinalprojectjavaee.service.Employee_AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class AssetController {
    private AssetService assetService ;
    private EmployeeService employeeService ;
    private Employee_AssetService employeeAssetService;

    private CategoryService categoryService;

    @Autowired
    public AssetController(AssetService assetService,EmployeeService employeeService,Employee_AssetService employeeAssetService,CategoryService categoryService) {
        this.employeeService = employeeService;
        this.assetService = assetService;
        this.employeeAssetService = employeeAssetService;
        this.categoryService = categoryService;;

    }

    @GetMapping("/assets")
    public String listAssets(Model model) {
        model.addAttribute("assets", assetService.getAllAssetEntitys());
        return "asset/assets";

    }

    @PostMapping("/assets")
    public String saveAsset(@ModelAttribute("asset") AssetEntity assetEntity) {
        assetService.saveAssetEntity(assetEntity);
        return "redirect:/assets";

    }



    @PostMapping("/assetSearch")
    public String searchAssetByTitle(@RequestParam("title") String title, Model model) {
        List<AssetEntity> assets = assetService.searchAssets(title);
        model.addAttribute("assets", assets);
        return "asset/search_asset";
    }


    @GetMapping("/assets/new")
    public String createAssetForm(Model model) {
        AssetEntity assetEntity=new AssetEntity();
        List<CategoryEntity> categoryEntities = categoryService.getAllCategories();
        model.addAttribute("categories", categoryEntities);
        model.addAttribute("asset", assetEntity);
        return "asset/create_asset";

    }

    @GetMapping("/assets/{assetId}/assign")
    public String showEmployees(@PathVariable("assetId") int assetId, Model model) {
        List<EmployeeEntity> employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);
        model.addAttribute("assetId", assetId);
        return "asset/assignEmployees";
    }
    @PostMapping("/assets/{assetId}/assign")
    public String assignEmployees(@PathVariable("assetId") int assetId, @RequestParam List<Integer> employeeIds,Model model) {
        employeeAssetService.assignEmployeeToAsset(assetId, employeeIds);
        List<Employee_AssetEntity > employeeAssets = employeeAssetService.getEmployee_AssetEntitiesByAssetId(assetId);
        model.addAttribute("employeeAssets", employeeAssets);
        model.addAttribute("assetId", assetId);
        return "employee_asset/assignedEmployees";
    }

//    @GetMapping("/assignedEmployees")
//    public String assignedEmployees(@PathVariable("assetId") int assetId, @RequestParam List<Integer> employeeIds,Model model) {
//        //employeeAssetService.assignEmployeeToAsset(assetId, employeeIds);
//        //List<Employee_AssetEntity > employeeAssets = employeeAssetService.getEmployee_AssetEntitiesByAssetId(assetId);
//        //model.addAttribute("employeeAssets", employeeAssets);
//        model.addAttribute("assetId", assetId);
//        return "employee_asset/assignedEmployees";
//    }


    @GetMapping("/assets/edit/{id}")
    public String editAssetForm(@PathVariable int id, Model model) {
        List<CategoryEntity> categoryEntities = categoryService.getAllCategories();
        model.addAttribute("categories", categoryEntities);
        model.addAttribute("asset", assetService.getAssetEntityById(id));
        return "asset/edit_asset";
    }

    @GetMapping("/assets/{id}")
    public String deleteAsset(@PathVariable int id) {
        assetService.deleteAssetEntityById(id);
        return "redirect:/assets";
    }

//    @DeleteMapping("/assets/{id}")
//    public String deleteAsset(@PathVariable int id) {
//        assetService.deleteAssetEntityById(id);
//        return "redirect:/assets";
//    }
    @PostMapping("/assets/{id}")
    public String updateStudent(@PathVariable int id,
                                @ModelAttribute("asset") AssetEntity assetEntity){
                             //   Model model) {

        AssetEntity existingAsset = assetService.getAssetEntityById(id);
        existingAsset.setId(id);
        existingAsset.setTitle(assetEntity.getTitle());
        existingAsset.setDescription(assetEntity.getDescription());
        existingAsset.setHealthyStatus(assetEntity.getHealthyStatus());
        CategoryEntity category = categoryService.getCategoryById(assetEntity.getCategoryEntity().getId());
        existingAsset.setCategoryEntity(category);
        existingAsset.setEmployeeAssetEntityList(assetEntity.getEmployeeAssetEntityList());
        assetService.updateAssetEntity(existingAsset);
        return "redirect:/assets";
    }


}
