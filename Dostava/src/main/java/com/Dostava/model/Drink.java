package com.Dostava.model;

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
@Table(name = "drinks")
public class Drink {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "drinksSequenceGenerator")
    @SequenceGenerator(name = "drinksSequenceGenerator", sequenceName = "drinksSequence", allocationSize = 1)
    private Long id;

    @Column (name = "name", nullable = false)
    private String name;

    @Column(name = "quantity", nullable = false)
    private String quantity;

    @Column (name = "unit",nullable = false)
    private Double unit;

}
