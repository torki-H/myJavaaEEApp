package com.example.myfinalprojectjavaee.dao;

import com.example.myfinalprojectjavaee.entity.AssetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssetRepo extends JpaRepository<AssetEntity,Integer> {
     List<AssetEntity> findByTitleLike(String title);
}
