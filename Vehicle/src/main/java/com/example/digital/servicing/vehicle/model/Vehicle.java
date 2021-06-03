package com.example.digital.servicing.vehicle.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table
public class Vehicle implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;



	@Column  
	private String vin;

	
	@Column
	private String year;
	
	@Column
	private String model;
	
	@Column
	private String make;
	
	@Column
	private String color;
	
	@Column
	private String style;
	
	@Column
	@NotBlank
	private String milage;
	
	
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	public String getMilage() {
		return milage;
	}
	public void setMilage(String milage) {
		this.milage = milage;
	}
	public Vehicle(String vin, String year, String model, String make, String color, String style, String milage) {
		super();
		this.vin = vin;
		this.year = year;
		this.model = model;
		this.make = make;
		this.color = color;
		this.style = style;
		this.milage = milage;
	}
	
	
	public Vehicle() {
		super();
	}
	


	

}
