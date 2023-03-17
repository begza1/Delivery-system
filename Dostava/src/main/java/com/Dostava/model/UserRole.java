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
@Table(name = "users_roles")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "usersRolesSequenceGenerator")
    @SequenceGenerator(name = "usersRolesSequenceGenerator", sequenceName = "usersRolesSequence", allocationSize = 1)
    private Long id;

    @Column
    private LocalDate createdAt = LocalDate.now();

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "fk_user_id")
    private User user;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "fk_role_id")
    private Role role;
}
