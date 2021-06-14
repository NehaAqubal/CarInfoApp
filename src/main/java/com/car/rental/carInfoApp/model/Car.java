package com.car.rental.carInfoApp.model;

import javax.persistence.*;

import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long c_Id;

	@Column(name = "Model_Name", nullable = false)
	private String modelName;

	@Column(name = "Brand", nullable = false)
	private String brand;
	
	@Column(name = "Color", nullable = false)
	private String color;

	@Column(name = "No_of_Pas", nullable = false)
	private String noOfPas;
	
	@Column(name = "Price", nullable = false)
	private long price;
	
	private String image;

	@Column(name = "Fueltype", nullable = false)
	private String fuelType;
	
	
	public Car()
	{}


	public Car(long c_Id, String modelName, String brand, String color, String noOfPas, long price, String image,
			String fuelType) {
		super();
		this.c_Id = c_Id;
		this.modelName = modelName;
		this.brand = brand;
		this.color = color;
		this.noOfPas = noOfPas;
		this.price = price;
		this.image = image;
		this.fuelType = fuelType;
	}


	public long getC_Id() {
		return c_Id;
	}


	public void setC_Id(long c_Id) {
		this.c_Id = c_Id;
	}


	public String getModelName() {
		return modelName;
	}


	public void setModelName(String modelName) {
		this.modelName = modelName;
	}


	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public String getNoOfPas() {
		return noOfPas;
	}


	public void setNoOfPas(String noOfPas) {
		this.noOfPas = noOfPas;
	}


	public long getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public String getFuelType() {
		return fuelType;
	}


	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}
	
	
	

}
