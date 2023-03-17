package com.Dostava.service;

import com.Dostava.dto.CreateRoleDto;
import com.Dostava.model.Role;
import com.Dostava.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor_ = @Lazy)

public class RoleService {

    public final RoleRepository roleRepository;
    private final UserService userService;



    public boolean createRole(CreateRoleDto createRoleDto){
        if(createRoleDto.getName() == null || createRoleDto.getName().trim().equals("")){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Role role = new Role(createRoleDto.getName());
        roleRepository.save(role);
        return true;

    }
    public Role findById(Long id){
        Optional<Role> optionalRole = roleRepository.findById(id);
        if(optionalRole.isEmpty()){
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return optionalRole.get();
    }

}

