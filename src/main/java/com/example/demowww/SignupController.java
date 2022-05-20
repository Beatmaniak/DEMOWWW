package com.example.demowww;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class SignupController {
    @Autowired UserRepository userRepository;
//    @GetMapping
//    public  addedUser(Model model){
//        model.addAttribute("string",userReporsitory.findAll());
//        return "/signup";
   // }
    @PostMapping("/signup")
    ResponseEntity<String> addUser(@Valid @RequestBody User user){
        return  ResponseEntity.ok("Signed up");
    }
    @GetMapping("/signup")
    public String login(@RequestParam(name="name", required=false, defaultValue="World") String name) {
        return "/signup";

        }

    @RequestMapping(value = "/addToDb", method = RequestMethod.POST)
    public @ResponseBody String create(User user) {
        userRepository.save(user);
        return "/signup";

        }


}

