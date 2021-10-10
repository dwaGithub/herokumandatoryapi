package edu.kea.herokuapi.models;

import lombok.Data;
import javax.persistence.*;

@Data
@Table(name="cars")
@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String brand;

    @Column
    private String model;

    @Column
    private String type;

}