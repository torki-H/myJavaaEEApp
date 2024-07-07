package com.example.myfinalprojectjavaee.service;

import com.example.myfinalprojectjavaee.dao.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;
//    public List<AssetEntity> listAssets(int cid){
//        Optional<AssetEntity> one = assetRepo.findById(cid);
//        if (!one.isPresent())
//            throw new UniversityException("Invalid Course ID");
//        AssetEntity AssetEntity = one.get();
//        List<AssetEntity> registers = AssetEntity.getRegisters();
//        return registers;
//    }
}
