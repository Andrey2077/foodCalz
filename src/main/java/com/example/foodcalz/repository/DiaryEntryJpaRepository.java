package com.example.foodcalz.repository;

import com.example.foodcalz.entity.DiaryEntryEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiaryEntryJpaRepository extends JpaRepository<DiaryEntryEntity, Long> {
}
