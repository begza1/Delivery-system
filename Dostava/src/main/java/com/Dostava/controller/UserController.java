package com.Dostava.controller;

import com.Dostava.dto.CreateUserDto;
import com.Dostava.dto.UpdateUserDto;
import com.Dostava.model.User;
import com.Dostava.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/users")

public class UserController {

    private final UserService userService;

    @PostMapping(produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<User> createUser(@RequestBody CreateUserDto createUserDto) {
        User user = userService.createUser(createUserDto);
        return ResponseEntity.ok(user);
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE, value = "/find-by-id/{id}")
    public ResponseEntity<User> findById(@PathVariable("id") Long id) {
        User user = userService.findById(id);
        return ResponseEntity.ok(user);

    }

    @PutMapping (produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE, value = "/{id}")
    public ResponseEntity<User> updateById (@PathVariable("id") Long id,
                                            @RequestBody UpdateUserDto updateUserDto){
        User user = userService.updateUser(id,updateUserDto);
        return ResponseEntity.ok(user);
    }
    @GetMapping (produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<User> findByIdAndUsername (
            @RequestParam(name = "ID", required = true) Long id,
            @RequestParam(name = "USERNAME", required = true) String username)
    {
        User user = userService.findByIdAndUsername(id,username);
        return ResponseEntity.ok(user);

}
    @DeleteMapping (value = "/{id}")
    public void deleteUserById (@PathVariable ("id")Long id) {
        userService.deleteUserById(id);
    }

}

//pitanje za urosa, zasto nisam mogla napraviti update bez metode findByIdAndUsername
