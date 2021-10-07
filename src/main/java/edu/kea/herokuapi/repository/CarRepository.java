package edu.kea.herokuapi.repository;

import edu.kea.herokuapi.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CarRepository extends JpaRepository<Car, Long> {
}