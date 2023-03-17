package com.Dostava.model;

import com.Dostava.model.enums.VehicleType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "vehicles")

public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "vehiclesSequenceGenerator")
    @SequenceGenerator(name = "vehiclesSequenceGenerator", sequenceName = "vehiclesSequence", allocationSize = 1)
    private Long id;

    @Column(name = "register_number", nullable = false)
    private String registerNumber;

    @Column(name = "vehicle_type", nullable = false)
    private VehicleType vehicleType;

}
