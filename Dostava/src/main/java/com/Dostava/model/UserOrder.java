package com.Dostava.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users_orders")
public class UserOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "usersOrdersSequenceGenerator")
    @SequenceGenerator(name = "usersOrdersSequenceGenerator", sequenceName = "usersOrdersSequence", allocationSize = 1)
    private Long id;

    @Column
    private LocalDate createdAt = LocalDate.now();

    @Column(name = "quantity", nullable = false)
    private Double quantity;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "fk_user_id")
    private User user;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "fk_order_id")
    private Order order;
}
