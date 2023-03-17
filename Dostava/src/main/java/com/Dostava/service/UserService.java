package com.Dostava.service;

import com.Dostava.dto.CreateUserDto;
import com.Dostava.dto.UpdateUserDto;
import com.Dostava.model.User;
import com.Dostava.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor_ = @Lazy)

public class UserService {

    private final UserRepository userRepository;

    public User createUser(CreateUserDto createUserDto) {
        User user = new User(createUserDto);

        user = userRepository.save(user);
        return user;
    }

    public User findById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if ((optionalUser.isEmpty())) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return optionalUser.get();
    }

    public User updateUser(Long id, UpdateUserDto updateUserDto) {

        User user = findById(id);

        user.setUsername(updateUserDto.getUsername());
        user = userRepository.save(user);
        return user;
    }

    public User findByIdAndUsername(Long id, String username) {
        Optional<User> optionalUser = userRepository.findByIdAndUsername(id, username);
        if (optionalUser.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            return optionalUser.get();
        }

    }

    public void deleteUserById(Long id) {
        User user = findById(id);

        userRepository.delete(user);
    }
}




