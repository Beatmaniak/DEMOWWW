package com.example.demowww;

import org.hibernate.annotations.common.reflection.XMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class SignupController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    private SecurityUserDetailsService userDetailsManager;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/register")
    public String register() {

        return "register";
    }
    @PostMapping(
            value = "/register",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = {
            MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }
    )
    public void addUser(@RequestParam Map<String, String> body) {
        User user = new User();
        user.setLogin(body.get("login"));
        user.setPassword(passwordEncoder.encode(body.get("password")));
        user.setNotLocked(true);
        user.setAge(Integer.parseInt(body.get("age")));
        user.setName(body.get("surname"));
        user.setSurname(body.get("surname"));
        userDetailsManager.createUser(user);
        userRepository.save(user);
    }

}




