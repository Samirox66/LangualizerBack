package com.example.LangualizerBack.controller;

import com.example.LangualizerBack.entity.UserEntity;
import com.example.LangualizerBack.exception.UserAlreadyExistException;
import com.example.LangualizerBack.exception.UserNotFoundException;
import com.example.LangualizerBack.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"http://localhost:3000"}, allowCredentials = "true")
@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("register")
    public ResponseEntity registration(@RequestBody UserEntity user) {
        try {
            userService.registration(user);
            return ResponseEntity.ok("User was saved");
        } catch (UserAlreadyExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @PostMapping("login")
    public ResponseEntity login(@RequestBody UserEntity user) {
        try {
            String userName = userService.login(user);
            return ResponseEntity.ok(userName);
        } catch (UserNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @GetMapping
    public ResponseEntity getOneUser(@RequestParam String email) {
        try {
            return ResponseEntity.ok(userService.getOne(email));
        } catch (UserNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }
}
