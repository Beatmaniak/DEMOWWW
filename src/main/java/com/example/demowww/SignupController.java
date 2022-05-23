package com.example.demowww;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@Controller
@RestController
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

//    @GetMapping("/register")
//    public String register() {
//
//        return "register";
//    }
    @PostMapping(
            value = "/register",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = {
            MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }
    )
    public String addUser(@RequestParam Map<String, String> body, @Valid User user2, BindingResult bindingResult) {
        User user = new User();
        user.setLogin(body.get("login"));
        user.setPassword(passwordEncoder.encode(body.get("password")));
        user.setNotLocked(true);
        user.setAge(Integer.parseInt(body.get("age")));
        user.setName(body.get("name"));
        user.setSurname(body.get("surname"));
        userDetailsManager.createUser(user);
        userRepository.save(user);
        if (bindingResult.hasErrors()) {
            return "register";
        }

        return "redirect:/login";
    }
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("user", new User());
        return "add-user";
    }
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String processAdd(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "add-user";
        }

        return "person-added-successfully";
    }
    }






