package com.example.demowww;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminSignupController{

    @GetMapping("/adminsignup")
    public String login(@RequestParam(name="name", required=false, defaultValue="World") String name) {
        return "adminsignup";
    }}
