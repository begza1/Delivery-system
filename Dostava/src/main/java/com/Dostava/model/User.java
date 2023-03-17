package com.Dostava.model;

import com.Dostava.dto.CreateUserDto;
import com.Dostava.dto.UpdateUserDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "usersSequenceGenerator")
    @SequenceGenerator(name = "usersSequenceGenerator", sequenceName = "usersSequence", allocationSize = 1)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "gender")
    private String gender;

    @Column(name = "address")
    private String address;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "paycheck", nullable = false)
    private Double paycheck;


    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<UserRole> userRoles = new HashSet<>();

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "fk_vehicle_id")
    private Vehicle vehicle;

    public User(CreateUserDto createUserDto) {
        this.firstName = createUserDto.getFirstName();
        this.lastName = createUserDto.getLastName();
        this.address = createUserDto.getAddress();
        this.password = createUserDto.getPassword();
        this.gender = createUserDto.getGender();
        this.username = createUserDto.getUsername();
        this.paycheck = createUserDto.getPaycheck();
    }


    }

