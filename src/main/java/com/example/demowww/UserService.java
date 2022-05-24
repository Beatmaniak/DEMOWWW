package com.example.demowww;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService{

    @Autowired
    private UserRepository userRepository;

    public List<User> usersAll(){
        return userRepository.findAll();
    }
    public User get(long id){
        return userRepository.findById(id).get();
    }
    public void delete(long id){
        userRepository.deleteById(id);
    }
    public void createUser(User user){
        userRepository.save(user);
    }

}
