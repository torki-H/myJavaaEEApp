package com.example.myfinalprojectjavaee.controller;

import com.example.myfinalprojectjavaee.entity.AssetEntity;
import com.example.myfinalprojectjavaee.service.AssetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AssetController {
    private AssetService assetService ;

    public AssetController(AssetService assetService) {
        super();
        this.assetService = assetService;
    }

    @GetMapping("/assets")
    public String listAssets(Model model) {
        model.addAttribute("assets", assetService.getAllAssetEntitys());
        return "asset/assets";

    }

    @PostMapping("/assets")
    public String saveStudent(@ModelAttribute("asset") AssetEntity assetEntity) {
        assetService.saveAssetEntity(assetEntity);
        return "redirect:/assets";

    }

    @GetMapping("/assets/new")
    public String createAssetForm(Model model) {
        AssetEntity assetEntity=new AssetEntity();
        model.addAttribute("asset", assetEntity);
        return "asset/create_asset";

    }

    @GetMapping("/assets/edit/{id}")
    public String editStudentForm(@PathVariable int id, Model model) {
        model.addAttribute("asset", assetService.getAssetEntityById(id));
        return "asset/edit_asset";

    }

    @GetMapping("/assets/{id}")
    public String deleteStudent(@PathVariable int id) {
        assetService.deleteAssetEntityById(id);
        return "redirect:/assets";
    }

    @PostMapping("/assets/{id}")
    public String updateStudent(@PathVariable int id,
                                @ModelAttribute("asset") AssetEntity assetEntity,
                                Model model) {

        // get student from database by id
        AssetEntity existingAsset = assetService.getAssetEntityById(id);
        existingAsset.setId(id);
        existingAsset.setTitle(assetEntity.getTitle());
        existingAsset.setDescription(assetEntity.getDescription());
        existingAsset.setHealthyStatus(assetEntity.getHealthyStatus());
     //   existingAsset.setCategoryEntity(assetEntity.getCategoryEntity());
        existingAsset.setEmployeeAssetEntityList(assetEntity.getEmployeeAssetEntityList());
        // save updated student object
        assetService.updateAssetEntity(existingAsset);
        return "redirect:/assets";
    }

}
