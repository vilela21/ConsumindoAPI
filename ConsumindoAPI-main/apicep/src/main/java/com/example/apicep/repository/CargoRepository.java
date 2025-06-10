package com.example.apicep.repository;

import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.stereotype.Repository; 

import com.example.apicep.model.CargoModel;

@Repository
public interface CargoRepository extends JpaRepository<CargoModel, Long> {
}
