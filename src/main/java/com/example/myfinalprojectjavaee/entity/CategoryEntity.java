package com.example.myfinalprojectjavaee.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "cattegory")
@Table(name = "cattegoryjavaeefinal")
@Data
@ToString
@NoArgsConstructor
public class CategoryEntity
{
    @Id
    @Column(name = "CategoriID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "categorySeq")
    @SequenceGenerator(name = "categorySeq",allocationSize = 1,sequenceName = "CATEGORY_SEQ")
    private int Id;

    @Column
    private String  description;
}
