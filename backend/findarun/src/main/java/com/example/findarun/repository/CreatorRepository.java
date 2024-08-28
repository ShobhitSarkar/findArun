package com.example.findarun.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.findarun.model.Creator;

public interface CreatorRepository extends JpaRepository <Creator, Long>  {
    
}
