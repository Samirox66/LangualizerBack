package com.example.LangualizerBack.service;

import com.example.LangualizerBack.entity.UserEntity;
import com.example.LangualizerBack.exception.UserAlreadyExistException;
import com.example.LangualizerBack.exception.UserNotFoundException;
import com.example.LangualizerBack.model.User;
import com.example.LangualizerBack.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserEntity registration(UserEntity user) throws UserAlreadyExistException {
        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new UserAlreadyExistException("User with this email have already registered");
        }
        return userRepository.save(user);
    }

    public String login(UserEntity user) throws UserNotFoundException {
        UserEntity checkingUser = userRepository.findByEmail(user.getEmail());
        if (checkingUser == null) {
            throw new UserNotFoundException("User with this email has not been registered yet");
        }
        if (!checkingUser.getPassword().equals(user.getPassword())) {
            throw new UserNotFoundException("User with this email had different password");
        }
        return checkingUser.getUsername();
    }

    public User getOne(String email) throws UserNotFoundException{
        UserEntity user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UserNotFoundException("User was not found");
        }
        return User.toModel(user);
    }
}
