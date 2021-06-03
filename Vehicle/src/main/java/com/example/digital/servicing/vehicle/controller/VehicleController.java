package com.example.digital.servicing.vehicle.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.digital.servicing.vehicle.exception.VehicleNotFoundException;
import com.example.digital.servicing.vehicle.model.Vehicle;
import com.example.digital.servicing.vehicle.service.VehicleService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/v1/vehicle")
public class VehicleController {
	
	@Autowired
	private VehicleService vehicleService;
	
	@Autowired
	private ObjectMapper objectMapper;

	
	
	@GetMapping("/{vin}")	
	public ResponseEntity<Vehicle> getVehicleDetails(@PathVariable("vin") String vin) throws VehicleNotFoundException {
		
		
	    Vehicle vehicle = vehicleService.findVehicleByVin(vin);
		 
		return new ResponseEntity<Vehicle>(vehicle, new HttpHeaders(), HttpStatus.OK);

		 
	}
	
	
	@GetMapping("/color/{color}")	
	public ResponseEntity<List<Vehicle>> getVehicleDetailsByColor(@PathVariable("color") String color) throws VehicleNotFoundException {
		
		
		List<Vehicle> vehicles = vehicleService.findVehicleByColor(color);
		 
		return new ResponseEntity<List<Vehicle>>(vehicles, new HttpHeaders(), HttpStatus.OK);

	
		 
		 
	}

	
	
	@PostMapping	
	public ResponseEntity<String> insertVehicleDetails(@RequestBody Vehicle vehicle) throws JsonProcessingException {
		long start = System.currentTimeMillis();
		Vehicle vehicleSaved = null;
		 vehicleSaved = vehicleService.saveVehicle(vehicle);
		 
	    System.out.println("saved vehicle information : "+objectMapper.writeValueAsString(vehicleSaved));
		return new ResponseEntity<String>("Record Saved Succesfully", new HttpHeaders(), HttpStatus.OK);

	
		 
		 
	}
	
	
	@PutMapping	
	public ResponseEntity<String> updateVehicleDetails(@RequestBody Vehicle vehicle) throws JsonProcessingException {
		long start = System.currentTimeMillis();
		Vehicle vehicleSaved = null;
		 vehicleSaved = vehicleService.saveVehicle(vehicle);
		 
	    System.out.println("saved vehicle information : "+objectMapper.writeValueAsString(vehicleSaved));
		return new ResponseEntity<String>("Record Saved Succesfully", new HttpHeaders(), HttpStatus.OK);

	
		 
		 
	}
	
	
	@DeleteMapping("/{vin}")	
	public ResponseEntity<String> deleteVehicleDetails(@PathVariable("vin") String vin) throws VehicleNotFoundException {
		
		System.err.println("inside delete");
		  vehicleService.deleteVehicleByVin(vin);
		 
		return new ResponseEntity<String>("Record deleted Succesfully", new HttpHeaders(), HttpStatus.OK);

	
		 
		 
	}



}
