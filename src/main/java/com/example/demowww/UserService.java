package com.example.demowww;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService{

    @Autowired
    private UserReporsitory userReporsitory;

    public User createUser(User user){
        return userReporsitory.save(user);
    }

}
