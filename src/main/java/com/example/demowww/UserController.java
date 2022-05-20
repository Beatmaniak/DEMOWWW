package com.example.demowww;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/api/")
public class UserController{
    @Autowired
    private UserRepository userRepository;
    public UserController(UserRepository userRepository){this.userRepository = userRepository;}



    @Autowired
    private UserService userService;

    @PostMapping("users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
        User savedUser= userService.createUser(user);
        return new ResponseEntity<User>(savedUser,HttpStatus.CREATED);
    }

}

