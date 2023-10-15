package com.example.demo.Controllers;

import com.example.demo.Model.User;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/sign-up")
    public ResponseEntity<?> signUp(@RequestBody User user) {
        User createdUser = userService.signUp(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @PostMapping("/sign-in")
    public ResponseEntity<?> signIn(@RequestBody User user) {
        String token = userService.signIn(user);
        return new ResponseEntity<>(token, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateUserDetails(@RequestBody User user) {
        User updatedUser = userService.updateUserDetails(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }
}