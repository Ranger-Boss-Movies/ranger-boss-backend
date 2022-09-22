package com.example.rangerbossbackend.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

    @RequestMapping({"/", "/about"})
    public String showView() {
        return "forward:/index.html";
    }
}