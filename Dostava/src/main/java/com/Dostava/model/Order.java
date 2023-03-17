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
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "ordersSequenceGenerator")
    @SequenceGenerator(name = "ordersSequenceGenerator", sequenceName = "ordersSequence", allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "fk_food_id")
    private Food food;

    @ManyToOne
    @JoinColumn(name = "fk_drink_id")
    private Drink drink;
}
