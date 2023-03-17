package com.Dostava.controller;

import com.Dostava.dto.CreateRoleDto;
import com.Dostava.model.Role;
import com.Dostava.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/roles")


public class RoleController {
    private final RoleService roleService;

    @PostMapping(produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    public boolean createRoles(@RequestBody CreateRoleDto createRoleDto) {
        return roleService.createRole(createRoleDto);

    }

    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public Role findById(@PathVariable("id") Long id) {
        return roleService.findById(id);
    }
}