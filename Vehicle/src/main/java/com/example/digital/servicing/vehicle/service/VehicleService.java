package com.example.digital.servicing.vehicle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.digital.servicing.vehicle.exception.VehicleNotFoundException;
import com.example.digital.servicing.vehicle.model.Vehicle;
import com.example.digital.servicing.vehicle.repository.VehicleRepository;

@Service
public class VehicleService {
	
	
	@Autowired
	private VehicleRepository vehicleRepository;
	
	public Vehicle findVehicleByVin(String vin) throws VehicleNotFoundException {
		
		Vehicle vehicle = vehicleRepository.findByVin(vin);
		
		
		if(vehicle == null) {
			throw new VehicleNotFoundException("no record found for vin number : " +vin);
		}
		
		return vehicle;
	}
	
	public Vehicle saveVehicle(Vehicle vehicle) {
		
		return vehicleRepository.save(vehicle);
		
	}
	
	
	public List<Vehicle> findVehicleByColor(String color){
		return vehicleRepository.findByColor(color);

	}
	
	public void deleteVehicleByVin(String vin) throws VehicleNotFoundException{
		
		try {
		vehicleRepository.deleteByVin(vin);
		}catch(Exception e) {
			e.printStackTrace();
			throw new VehicleNotFoundException("no record found for vin number : "+vin);
			

		}

	}


}
