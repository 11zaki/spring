package com.example.demo.service;
import java.util.List;



import com.example.demo.entity.Car;

  

public interface ICarService {
     List<Car> getAllCar();
     Car saveCar(Car car);
     Car getCarById(Long id);
     Car updateCar(Car car);
     void deletCarById(long id);
    
}