package com.example.myfinalprojectjavaee.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

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

    @ManyToOne
    @JoinColumn(name = "FK_EmpID",referencedColumnName = "EmpID")
    private EmployeeEntity employeeEntity;

    @ManyToOne
    @JoinColumn(name = "FK_AssetID",referencedColumnName = "AssetID",nullable = false)
    private AssetEntity assetEntity;

    @Column
    private int version;

    @Column
    private Boolean assignStatus;

    @Column
    private Date assignedDate;

    @Column
    private Date unassignedDate;

    public Date getAboardDate() {
        return this.assetEntity != null ? this.assetEntity.getAboardDate() : null;
    }
}
