package com.example.myfinalprojectjavaee.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "employee_asset")
@Table(name = "employeeassetjavaeefinal")
@Data
//@IdClass(Employee_Asset_PKEntity.class)
@ToString
@NoArgsConstructor

public class Employee_AssetEntity {
    @Id
    @Column(name = "EmpAssID",columnDefinition = "NUMBER")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "employAssetSeq")
    @SequenceGenerator(name = "employAssetSeq",allocationSize = 1,sequenceName = "EMPLOYASSET_SEQ")
    private int Id;

//    @Id
//    @Column(name = "FK_EmpID"/*,columnDefinition = "NUMBER"*/)
//    private int EmId;
//
//    @Id
//    @Column(name = "FK_AssetID"/*,columnDefinition = "NUMBER"*/)
//    private int AsId;

//    @EmbeddedId
//    private Employee_Asset_PKEntity employee_asset_pkEntity;


    //@Id
    @ManyToOne
    @JoinColumn(name = "FK_EmpID",referencedColumnName = "EmpID")
    private EmployeeEntity employeeEntity;

    //@Id
    @ManyToOne
    @JoinColumn(name = "FK_AssetID",referencedColumnName = "AssetID"/*"CID"*/)//درس و ثبت نام
    private AssetEntity assetEntity;


}
