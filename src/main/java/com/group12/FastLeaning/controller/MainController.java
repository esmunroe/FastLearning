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

    @GetMapping("/courseList")
    public String courseList(){
        return "courseList";
    }

    @GetMapping("/courseName")
    public String courseName(){
        return "courseName";
    }

    @GetMapping("/course")
    public String course(){
        return "course";
    }
}
