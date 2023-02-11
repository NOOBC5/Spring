package com.example.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class controller {

    @GetMapping("/")
    public String Main(){

        return "main";
    }

    @GetMapping("/Diary")
    public String Diary(){

        return "Diary";
    }
}
