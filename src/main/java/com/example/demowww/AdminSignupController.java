package com.example.demowww;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
    @RequestMapping("/edit/{id}")
    public ModelAndView showEditProductPage(@PathVariable(name = "sn") Long sn) {
        ModelAndView mav = new ModelAndView("edit_user");
        User user = service.get(sn);
        mav.addObject("user",user);

        return mav;
    }

    @GetMapping("/adminsignup")
    public String login(@RequestParam(name="name", required=false, defaultValue="World") String name) {
        return "adminsignup";
    }}
