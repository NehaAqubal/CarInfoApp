package com.car.rental.carInfoApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.car.rental.carInfoApp.model.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {}
