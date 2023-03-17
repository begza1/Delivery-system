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
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "rolesSequenceGenerator")
    @SequenceGenerator(name = "rolesSequenceGenerator", sequenceName = "rolesSequence", allocationSize = 1)
    private Long id;

    @Column(name = "name",nullable = false)
    private String name;

    public Role(String name) {
    }
}
