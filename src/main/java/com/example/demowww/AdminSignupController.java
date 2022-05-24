package com.example.demowww;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AdminSignupController{
    private UserService service;

    @RequestMapping("/")
    public String viewHomePage(Model model) {
        List<User> userList = service.usersAll();
        model.addAttribute("userList",userList);

        return "adminsignup";
    }
    @GetMapping("/adminsignup")
    public String login(@RequestParam(name="name", required=false, defaultValue="World") String name) {
        return "adminsignup";
    }}
