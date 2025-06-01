package com.finanza.finanza_progetto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping("")
    public String login() {
        return "/log/login";
    }

}
