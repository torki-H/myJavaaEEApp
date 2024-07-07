package com.example.myfinalprojectjavaee.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity(name = "asset")
@Table(name = "assetjavaeefinal")
@Data
@ToString
@NoArgsConstructor
public class AssetEntity// extends JpaEntity
    {
    @Id
    @Column(name = "AssetID"/*,columnDefinition = "NUMBER"*/)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "assetSeq")
    @SequenceGenerator(name = "assetSeq",allocationSize = 1,sequenceName = "ASSET_SEQ")
    private int id;
//    @Column
//    private int identificationNumber;
    @Column
    private String title;
    @Column
    private Boolean healthyStatus;
    @Column
    private String description;

    @OneToMany(targetEntity = Employee_AssetEntity.class,fetch = FetchType.LAZY )
    @JoinColumn(name = "FK_AssetID",referencedColumnName = "AssetID"/*"CID"*/)//درس و ثبت نام
    private List<Employee_AssetEntity> employeeAssetEntityList;


    @ManyToOne
    @JoinColumn(name = "FK_CategoriID",referencedColumnName = "CategoriID")
    private CategoryEntity categoryEntity;

    public AssetEntity(String title, Boolean healthyStatus ,String description) {
        this.title = title;
        this.healthyStatus = healthyStatus;
        this.description = description;
    }

    public AssetEntity(int id, String title, Boolean healthyStatus, String description) {
        this.id = id;
        this.title = title;
        this.healthyStatus = healthyStatus;
        this.description = description;
    }

}
