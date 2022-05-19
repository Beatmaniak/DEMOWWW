package com.example.demowww;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class SignupController {
    @PostMapping("/signup")
    ResponseEntity<String> addUser(@Valid @RequestBody User user){
        return  ResponseEntity.ok("Signed up");
    }
    @GetMapping("/signup")
    public String login(@RequestParam(name="name", required=false, defaultValue="World") String name) {
        return "/signup";

}}

