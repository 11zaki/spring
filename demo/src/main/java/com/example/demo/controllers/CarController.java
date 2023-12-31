package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Car;
import com.example.demo.service.ICarService;

@Controller
public class CarController {
    @Autowired
    private ICarService icarService;
   

     public CarController(ICarService icarService) {
        super();
        this.icarService = icarService;
    }



    @GetMapping("/cars")
    public String listCar(Model model){
        model.addAttribute("cars", icarService.getAllCar());
        return "cars";
    }
    @GetMapping("/cars/new")
    public String createCarForm(Model model){
        Car car=new Car();
        model.addAttribute("car", car);
        return "create_car";

    }
    @PostMapping("/cars")
    public String saveCar(@ModelAttribute("cars") Car car){
        icarService.saveCar(car);
        return "redirect:/cars";
    }
    @GetMapping("cars/edit/{id}")
    public String editCarForm(@PathVariable Long id, Model model){
     model.addAttribute("car", icarService.getCarById(id));
     return "edit_cars";
    }
    @PostMapping("/cars/{id}")
    public String updateCar(@PathVariable Long id , @ModelAttribute ("car") Car car, Model model){
        Car existingCar= icarService.getCarById(id);
        existingCar.setMarque(car.getMarque());
        existingCar.setModel(car.getModel());
        existingCar.setColor(car.getColor());
        existingCar.setKilometrage(car.getKilometrage());
        existingCar.setPrix(car.getPrix());
        existingCar.setTransmission(car.getTransmission());
        icarService.updateCar(existingCar);
        return "redirect:/cars";
    }
    @GetMapping("/cars/{id}")
    public String deletCar(@PathVariable Long id){
       icarService.deletCarById(id);
       return "redirect:/cars";
    }
    
    
}