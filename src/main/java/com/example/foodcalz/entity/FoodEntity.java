package com.example.foodcalz.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "food")
@NoArgsConstructor
@Getter
@Setter
public class FoodEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @SequenceGenerator(name = "sequence", sequenceName = "sequence", allocationSize = 1)
    private Long id;


    @Column
    private String name;

    @Column
    private String brand;

    @Column
    private int kcal;
    @Column
    private int protein;
    @Column
    private int fat;
    @Column
    private int carbs;


}
