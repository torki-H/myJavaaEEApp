//package com.example.myfinalprojectjavaee.entity;
//
//import jakarta.persistence.*;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import lombok.ToString;
//
//import java.util.List;
//
//@Entity(name = "user")
//@Table(name = "userjavaeefinal")
//@Data
//@ToString
//@NoArgsConstructor
//public class UserEntity
//   {
//    @Id
//    @Column(name = "UsrID",columnDefinition = "NUMBER")
//    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "usrSeq")
//    @SequenceGenerator(name = "usrSeq",allocationSize = 1,sequenceName = "USERENTITY_SEQ")
//    private int Id;
//    @Column
//    private String userName;
//    @Column
//    private String password;
//
//
//    @OneToOne(mappedBy = "user") // مشخص کردن اینکه اینجا مالک نیستیم
//    private EmployeeEntity employee;
//}
