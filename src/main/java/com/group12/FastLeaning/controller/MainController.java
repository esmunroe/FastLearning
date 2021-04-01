package com.group12.FastLeaning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@ControllerAdvice
public class MainController {
    @GetMapping("/")
    public String main(){
        return "index";
    }
}