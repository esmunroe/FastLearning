package com.group12.FastLearning.controller;

import com.group12.FastLearning.model.Course;
import com.group12.FastLearning.model.Post;
import com.group12.FastLearning.service.CourseService;
import com.group12.FastLearning.service.PostService;
import com.group12.FastLearning.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
@ControllerAdvice
public class MainController {
    @Autowired
    CourseService courseService;

    @Autowired
    UserService userService;
    
    @Autowired
    PostService postService;

    @GetMapping("/")
    public String main(){
        return "index";
    }

    @GetMapping("/about")
    public String about(){
        return "about";
    }

    @ModelAttribute("courses")
    public List<Course> courses() {
        return courseService.findAll();
    }

    @GetMapping("/courseList")
    public String courseList(){
        return "courseList";
    }
    
    @ModelAttribute("posts")
    public List<Post> posts() {
        return postService.findAll();
    }
}
