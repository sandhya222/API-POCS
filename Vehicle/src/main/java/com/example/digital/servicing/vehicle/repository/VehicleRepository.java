package com.example.digital.servicing.vehicle.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.digital.servicing.vehicle.model.Vehicle;


public interface VehicleRepository extends JpaRepository<Vehicle,Long>{
	
	
    Vehicle findByVin(String vin);
 
    List<Vehicle> findByColor(String color);
    
    List<Vehicle> findByMake(String make);
    
    
    @Transactional
    void deleteByVin(String vin);

}
