package com.example.myfinalprojectjavaee.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
//import org.springframework.format.annotation.StringTimeFormat;

//import java.util.Date;
import java.util.List;

@Entity(name = "employee")
@Table(name = "employeejavaeefinal")
@Data
@ToString
@NoArgsConstructor
//@EntityListeners(WhoEntities.class)
public class EmployeeEntity// extends JpaEntity
   {
    @Id
    @Column(name = "EmpID",columnDefinition = "NUMBER")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "employSeq")
    @SequenceGenerator(name = "employSeq",allocationSize = 1,sequenceName = "EMPLOYEE_SEQ")
    private int Id;
    @Column
    private String name;
    @Column
    private String family;
    @Column
    //@StringTimeFormat(pattern = "yyyyMMdd")
    private String employedDate;

    //@Column????
    @OneToMany(targetEntity = Employee_AssetEntity.class,fetch = FetchType.LAZY  )
    @JoinColumn(name = "FK_EmpID",referencedColumnName = "EmpID"/*"CID"*/)//درس و ثبت نام
    private List<Employee_AssetEntity> employeeAssetEntityList;

    public EmployeeEntity(String name, String family, String employedDate
    ) {
        this.name = name;
        this.family = family;
        this.employedDate = employedDate;
    }

    public EmployeeEntity(int id, String name, String family, String employedDate) {
        Id = id;
        this.name = name;
        this.family = family;
        this.employedDate = employedDate;
    }
}
