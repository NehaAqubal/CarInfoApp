package com.car.rental.carInfoApp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.SerializationUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.car.rental.carInfoApp.Service.PublishMessageService;
import com.car.rental.carInfoApp.dao.CarRepository;
import com.car.rental.carInfoApp.model.Car;

@RequestMapping("/CarRental")
@RestController
public class CarController {

	@Autowired
	CarRepository carRepository;
	

	@Autowired
	PublishMessageService publishMessageService;

	@GetMapping("/MyEndCarInfo")
	public String MyEnd() {
		return "Hello for CarInfo";
	}

	@GetMapping(value = "/carDetails", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Car>> getAllCarInfo() {
		try {
			List<Car> cardetails = new ArrayList<Car>();

			carRepository.findAll().forEach(cardetails::add);

			if (cardetails.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(cardetails, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/carDetailsById/{id}")
	public ResponseEntity<Car> getCarById(@PathVariable("id") long id) {
		Optional<Car> carData = carRepository.findById(id);

		if (carData.isPresent()) {
			Car car= carData.get();
//			HashMap<String,Long> map =new HashMap<String,Long>();
//			map.put("C_ID", car.getC_Id());
//			map.put("Price", car.getPrice());
			
			List<Long> myList=new ArrayList<Long>();
			myList.add(car.getC_Id());
			myList.add(car.getPrice());
			//Object obj=myList;
			//publishMessageService.publish(car.getC_Id());
			SerializationUtils.serialize(myList);
			publishMessageService.publish(SerializationUtils.serialize(myList) );
			return new ResponseEntity<>(car, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

//	@GetMapping("/carDetailsById/{id}")
//	public ResponseEntity getUserById(@PathVariable("id") long id) {
//		Optional<Car> carData = carRepository.findById(id);
//
//		if (carData.isPresent()) {
//			return new ResponseEntity<>("hello", HttpStatus.OK);
//		} else {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//	}
}
