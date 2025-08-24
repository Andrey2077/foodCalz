package com.example.foodcalz.entity;


import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

//id, user, food, date, mealType, grams.

@Entity
@Table(name = "diary_entries")
@NoArgsConstructor
public class DiaryEntryEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @SequenceGenerator(name = "sequence", sequenceName = "sequence", allocationSize = 1)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "food_id", nullable = false)
    private FoodEntity food;

    @Column
    private LocalDateTime date;

    @Column
    private int mealType;
    @Column
    private int grams;

}
