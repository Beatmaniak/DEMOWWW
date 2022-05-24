package com.example.demowww;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/api/")
public class UserController{
    @Autowired
    private UserRepository userRepository;
    public UserController(UserRepository userRepository){this.userRepository = userRepository;}

//    @RequestMapping(value = "/getUsers", method = RequestMethod.GET)
//    public String getUsers(Model model) throws Exception{
//        List<User> users=getListofUsers();
//        UserListContainer userList= new UserListContainer();
//        userList.setUsers(users);
//        model.addAttribute("Users",userList);
//        return "showUsers";
//    }

    private List<User> getListofUsers() {
        List<User> users= new ArrayList<User>();
        return users;
    }


    @Autowired
    private UserService userService;

//    @PostMapping("users")
//    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
//        User savedUser= userService.createUser(user);
//        return new ResponseEntity<User>(savedUser,HttpStatus.CREATED);
//    }

}

