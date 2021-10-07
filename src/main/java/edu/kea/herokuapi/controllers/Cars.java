package edu.kea.herokuapi.controllers;

import edu.kea.herokuapi.models.Car;
import edu.kea.herokuapi.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Cars {

    @Autowired
    CarRepository cars;


    @GetMapping("/cars")
    Iterable<Car> getCars() {
        return cars.findAll();
    }

    @GetMapping("/cars/{id}")
    public Car getCarsById(@PathVariable Long id) {
        return cars.findById(id).get();
    }

    @PostMapping("/cars")
    public Car addCar(@RequestBody Car newCar) {
        return cars.save(newCar);
    }

    @PostMapping("/cars/showroom/{car_id}/{showroom_id}")
    public Car addShowroomToCar(@PathVariable long showroom_id, @PathVariable long car_id){
        System.out.println(car_id);
        System.out.println(showroom_id);
        return null;
    }

    @PutMapping("/cars/{id}")
    public String updateCarById(@PathVariable Long id, @RequestBody Car carToUpdateWith){
        if(cars.existsById(id)){
            carToUpdateWith.setId(id);
            cars.save(carToUpdateWith);
            return "Car was created";
        } else {
            return "Car not found";
        }
    }


    @PatchMapping("/cars/{id}")
    public String patchCarById(@PathVariable Long id, @RequestBody Car carToUpdateWith){
        return cars.findById(id).map(foundCar -> {
            if(carToUpdateWith.getBrand() != null) foundCar.setBrand(carToUpdateWith.getBrand());
            if(carToUpdateWith.getModel() !=0) foundCar.setModel(carToUpdateWith.getModel());
            if(carToUpdateWith.getType() != null) foundCar.setType(carToUpdateWith.getType());
            cars.save(foundCar);
            return "Car updated";
        }).orElse("Car now found");
    }


    @DeleteMapping("/cars/{id}")
    public void deleteCarById(@PathVariable Long id){
        cars.deleteById(id);
    }
}
