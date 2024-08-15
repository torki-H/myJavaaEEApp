package com.example.myfinalprojectjavaee.service;

import com.example.myfinalprojectjavaee.dao.AssetRepo;
import com.example.myfinalprojectjavaee.dao.EmployeeRepo;
import com.example.myfinalprojectjavaee.dao.Employee_AssetRepo;
import com.example.myfinalprojectjavaee.entity.AssetEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AssetService {
    @Autowired
    private AssetRepo assetRepo;

    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    //private EmployeeAssetEntityRepository employeeAssetEntityRepository;
    private Employee_AssetRepo employeeAssetRepo;



    public List<AssetEntity> getAllAssetEntitys() {
        return assetRepo.findAll();
    }

    public AssetEntity saveAssetEntity(AssetEntity AssetEntity) {
        return assetRepo.save(AssetEntity);
    }

    public AssetEntity getAssetEntityById(int id) {
        //return assetRepo.findById(id).get();
        return assetRepo.findAssetEntityById(id);
    }

    public AssetEntity updateAssetEntity(AssetEntity AssetEntity) {
        return assetRepo.save(AssetEntity);
    }



    public List<AssetEntity> searchAssets(String title) {
        return assetRepo.findByTitleLike("%" + title + "%");

    }


    public void deleteAssetEntityById(int id) {
        // ابتدا موجودیت‌های وابسته را پیدا کن
        AssetEntity assetEntity = assetRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("not found asst"));
        assetRepo.delete(assetEntity);
        // حالا موجودیت اصلی را حذف کن
        //assetRepo.deleteById(id);
    }


}
