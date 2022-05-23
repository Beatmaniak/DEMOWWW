package com.example.demowww;

import org.springframework.web.bind.annotation.GetMapping;

public class UserPanelController {
    @GetMapping("/UserPanel")
    public String Panel() {

        return "UserPanel";
    }
}
