package com.example.demowww;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {


//    @GetMapping("/login")
//    public String login(){
//        return "login";
//    }

    @Resource(name="authenticationManager")
    private AuthenticationManager authManager;

    public LoginController() {
        super();
    }

    // API

    // custom login

    @RequestMapping(value = "/login", method = {RequestMethod.POST,RequestMethod.GET})
    public void login(@RequestParam(name="login",required = false) final String login, @RequestParam(name="password",required = false) final String password, final HttpServletRequest request) {
        UsernamePasswordAuthenticationToken authReq =
                new UsernamePasswordAuthenticationToken(login, password);
        Authentication auth = authManager.authenticate(authReq);
        SecurityContext sc = SecurityContextHolder.getContext();
        sc.setAuthentication(auth);
        HttpSession session = request.getSession(true);
        session.setAttribute("SPRING_SECURITY_CONTEXT", sc);
    }
}
