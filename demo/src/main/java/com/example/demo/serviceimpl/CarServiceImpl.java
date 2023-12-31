package com.example.demo.serviceimpl;


import org.springframework.stereotype.Service;
import java.util.List;
import com.example.demo.entity.Car;
import com.example.demo.repository.CarRepository;
import com.example.demo.service.ICarService;
@Service
public class CarServiceImpl implements ICarService {

    private CarRepository carRepository;
    
    
    public CarServiceImpl(CarRepository carRepository) {
        super();
        this.carRepository = carRepository;
    }
      @Override
    public List<Car> getAllCar() {
        return carRepository.findAll();
    }
    @Override
    public Car saveCar(Car car) {
      return carRepository.save(car);
    }
    @Override
    public Car getCarById(Long id) {
       return carRepository.findById(id).get();
    }
    @Override
    public Car updateCar(Car car) {
        return carRepository.save(car);
        
    }
    @Override
    public void deletCarById(long id) {
        carRepository.deleteById(id);
    }
   
}