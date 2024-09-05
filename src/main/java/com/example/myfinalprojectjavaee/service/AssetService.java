package com.example.myfinalprojectjavaee.service;

import com.example.myfinalprojectjavaee.dao.AssetRepo;
import com.example.myfinalprojectjavaee.dao.EmployeeRepo;
import com.example.myfinalprojectjavaee.dao.Employee_AssetRepo;
import com.example.myfinalprojectjavaee.entity.AssetEntity;
import com.example.myfinalprojectjavaee.entity.Employee_AssetEntity;
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
        return assetRepo.findAssetEntityById(id);
    }

    public AssetEntity updateAssetEntity(AssetEntity AssetEntity) {
        return assetRepo.save(AssetEntity);
    }



    public List<AssetEntity> searchAssets(String title) {
        return assetRepo.findByTitleLike("%" + title + "%");

    }


    public void deleteAssetEntityById(int id) {
        AssetEntity assetEntity = assetRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("not found asst"));

        List<Employee_AssetEntity> employeeAssetEntities = employeeAssetRepo.findEmployee_AssetEntitiesByAssetId(id);
        for (Employee_AssetEntity employeeAssetEntity:employeeAssetEntities) {
            employeeAssetRepo.delete(employeeAssetEntity);
        }
        assetRepo.deleteById(id);

    }


}
