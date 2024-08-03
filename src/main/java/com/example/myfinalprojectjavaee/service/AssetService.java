package com.example.myfinalprojectjavaee.service;

import com.example.myfinalprojectjavaee.dao.AssetRepo;
import com.example.myfinalprojectjavaee.dao.EmployeeRepo;
import com.example.myfinalprojectjavaee.dao.Employee_AssetRepo;
import com.example.myfinalprojectjavaee.entity.AssetEntity;
import com.example.myfinalprojectjavaee.entity.EmployeeEntity;
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


    /*public boolean addOne(AssetEntity AssetEntity) {
        try {
            assetRepo.save(AssetEntity);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean editOne(AssetEntity AssetEntity) {
        try {
            assetRepo.save(AssetEntity);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public boolean deleteOne(int id) {
        try {
            assetRepo.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<AssetEntity> getAll(){
        return assetRepo.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    public Optional<AssetEntity> getOne(int id){
        return assetRepo.findById(id);
    }*/

//    public List<AssetEntity> listAssets(int cid){
//        Optional<AssetEntity> one = assetRepo.findById(cid);
//        if (!one.isPresent())
//            throw new UniversityException("Invalid Course ID");
//        AssetEntity AssetEntity = one.get();
//        List<AssetEntity> registers = AssetEntity.getRegisters();
//        return registers;
//    }






    public List<AssetEntity> getAllAssetEntitys() {
        return assetRepo.findAll();
    }

    public AssetEntity saveAssetEntity(AssetEntity AssetEntity) {
        return assetRepo.save(AssetEntity);
    }

    public AssetEntity getAssetEntityById(int id) {
        return assetRepo.findById(id).get();
        //return assetRepo.findById(id);
    }

    public AssetEntity updateAssetEntity(AssetEntity AssetEntity) {
        return assetRepo.save(AssetEntity);
    }

    public void deleteAssetEntityById(int id) {
        assetRepo.deleteById(id);
    }

    public List<AssetEntity> searchAssets(String title){
        return assetRepo.findByTitleLike("%" + title + "%");

    }





}
