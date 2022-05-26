package com.example.demowww;

import java.util.*;

import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;
import com.example.demowww.User;
import com.example.demowww.UserRepository;

import javax.annotation.PostConstruct;


@Service
public class SecurityUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private SecurityUserDetailsService userDetailsManager2;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        User user = userRepository.findUserByLogin(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not present"));
        return user;
    }
    public void createUser(UserDetails user) {
        userRepository.save((User) user);
    }

    private Map<String, User> roles = new HashMap<>();

    @PostConstruct
    public void init() {
        roles.put("admin2", new User(1L,"jan","jan","janek","janek",20,true, getAuthority("ADMIN")));
        User user1 = new User();
        user1.setLogin("janek");
//        user.setPassword(passwordEncoder.encode(body.get("password")));
        user1.setPassword("janek");
        user1.setNotLocked(true);
        user1.setAge(20);
        user1.setName("jan");
        user1.setSurname("jan");
        user1.setSn(1L);


        userRepository.save(user1);
        roles.put("user2", new User(2L,"janek","janek","janko","janko",20,true,getAuthority("USER")));
        User user2 = new User();
        user2.setLogin("janko");
//        user.setPassword(passwordEncoder.encode(body.get("password")));
        user2.setPassword("janko");
        user2.setNotLocked(true);
        user2.setAge(20);
        user2.setName("janek");
        user2.setSurname("janek");
        user2.setSn(2L);
//

        userRepository.save(user2);
    }


    private List<GrantedAuthority> getAuthority(String role) {
        return Collections.singletonList(new SimpleGrantedAuthority(role));
    }

}