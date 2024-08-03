package com.example.myfinalprojectjavaee.controller;

import com.example.myfinalprojectjavaee.entity.AssetEntity;
import com.example.myfinalprojectjavaee.entity.EmployeeEntity;
import com.example.myfinalprojectjavaee.entity.Employee_AssetEntity;
import com.example.myfinalprojectjavaee.service.AssetService;
import com.example.myfinalprojectjavaee.service.EmployeeService;
import com.example.myfinalprojectjavaee.service.Employee_AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller

public class EmployeeController {
    private EmployeeService EmployeeService ;

    @Autowired
    private AssetService assetService ;
    @Autowired
    private Employee_AssetService employeeAssetService;

    public EmployeeController(EmployeeService EmployeeService) {
        super();
        this.EmployeeService = EmployeeService;
    }

    @GetMapping("/employees")
    public String listemployees(Model model) {
        model.addAttribute("employees", EmployeeService.getAllEmployees());
        return "employee/employees";
    }

    @GetMapping("/employees/new")
    public String createemployeeForm(Model model) {

        EmployeeEntity EmployeeEntity=new EmployeeEntity();
        model.addAttribute("employee", EmployeeEntity);
        return "employee/create_employee";

    }

    @PostMapping("/employees")
    public String saveStudent(@ModelAttribute("employee") EmployeeEntity EmployeeEntity) {
        EmployeeService.saveEmployeeEntity(EmployeeEntity);
        return "redirect:/employees";
    }

    @GetMapping("/employees/edit/{id}")
    public String editStudentForm(@PathVariable int id, Model model) {
        model.addAttribute("employee", EmployeeService.getEmployeeEntityById(id));
        return "employee/edit_employee";

    }

    @PostMapping("/employees/{id}")
    public String updateStudent(@PathVariable int id,
                                @ModelAttribute("employee") EmployeeEntity EmployeeEntity){
                          //      Model model) {

        EmployeeEntity existingemployee = EmployeeService.getEmployeeEntityById(id);
        existingemployee.setId(id);
        existingemployee.setEmployedDate(EmployeeEntity.getEmployedDate());
        existingemployee.setName(EmployeeEntity.getName());
        existingemployee.setFamily(EmployeeEntity.getFamily());
        existingemployee.setEmployeeAssetEntityList(EmployeeEntity.getEmployeeAssetEntityList());
        EmployeeService.updateEmployeeEntity(existingemployee);
        return "redirect:/employees";
    }

    @GetMapping("/employees/{id}")
    public String deleteStudent(@PathVariable int id) {
        EmployeeService.deleteEmployeeEntityById(id);
        return "redirect:/employees";
    }

    @GetMapping("/search")
    public String searchEmployeeForm() {
        return "employee/search_employee";
    }

    @PostMapping("/search")
    public String searchEmployeeByName(@RequestParam("name") String name, Model model) {
        List<EmployeeEntity> employees = EmployeeService.searchEmployees(name);
        model.addAttribute("employees", employees);
        return "employee/search_employee";
    }

    @GetMapping("/allocateAsset")
    public String allocateAssetForm(Model model) {
        List<EmployeeEntity> employees = EmployeeService.getAllEmployees();
        List<AssetEntity> assets = assetService.getAllAssetEntitys();
        model.addAttribute("employees", employees);
        model.addAttribute("assets", assets);
        return "allocateAssetForm";
    }

    @PostMapping("/allocateAsset")
    public String allocateAsset(@RequestParam("employeeId") int employeeId, @RequestParam("assetId") int assetId) {
        EmployeeEntity employee = EmployeeService.getEmployeeEntityById(employeeId);
        AssetEntity asset = assetService.getAssetEntityById(assetId);
        Employee_AssetEntity assetAllocation = new Employee_AssetEntity();
        assetAllocation.setEmployeeEntity(employee);
        assetAllocation.setAssetEntity(asset);
        employeeAssetService.assignEmployeeToAsset(employeeId,assetId);
        return "redirect:/assets";
    }

}
