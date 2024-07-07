package com.example.myfinalprojectjavaee.controller;

import com.example.myfinalprojectjavaee.entity.Employee_AssetEntity;
import com.example.myfinalprojectjavaee.service.AssetService;
import com.example.myfinalprojectjavaee.service.EmployeeService;
import com.example.myfinalprojectjavaee.service.Employee_AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AssignToEmployeeController {

    private AssetService assetService ;
//    com.example.myfinalprojectjavaee.service.
    private EmployeeService EmployeeService ;

    private Employee_AssetService employeeAssetService;



    @Autowired
    public AssignToEmployeeController(AssetService assetService, EmployeeService employeeService,Employee_AssetService employeeAssetService ) {
        this.assetService = assetService;
        this.EmployeeService = employeeService;
        this.employeeAssetService = employeeAssetService;

    }

    @GetMapping("/assignAsset")
    public String showAssignAssetForm(Model model) {
        // populate model with necessary data for the form
        // for example, list of assets and employees
        model.addAttribute("assignAssetToEmployee", new Employee_AssetEntity());
        model.addAttribute("assets", assetService.getAllAssetEntitys());
        model.addAttribute("employees", EmployeeService.getAllEmployees());
        return "assignAssetForm";
    }

    @PostMapping("/assignAsset")
    public String assignAssetToEmployee(@ModelAttribute Employee_AssetEntity employeeAssetEntity ) {
        // Save the assignment to the database

        employeeAssetService.assignAssetToEmployee(employeeAssetEntity.getAssetEntity().getId(), employeeAssetEntity.getEmployeeEntity().getId());
        return "redirect:/assign_asset"; // redirect to the assets page
    }
   //یادت باشه جدول واسط را id اضافه کردم
}
