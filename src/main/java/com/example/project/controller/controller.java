package com.example.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
