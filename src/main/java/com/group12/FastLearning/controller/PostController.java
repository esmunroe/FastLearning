package com.group12.FastLearning.controller;


import com.group12.FastLearning.model.Post;
import com.group12.FastLearning.model.PostService;
import com.group12.FastLearning.model.User;
import com.group12.FastLearning.service.UserService;
import com.group12.FastLearning.model.Course;
import com.group12.FastLearning.model.CourseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class PostController {

    @Autowired
    private PostService postService;
    
    
    //show all posts
    /*
    @RequestMapping("/posts")
    public String viewAll(Model model) {
      List<Post> allPosts = postService.findAll()
      model.addAttribute(allPosts);
      return "posts";  */
      
      
    //show individual post 
    
    @RequestMapping("/posts/{id}")
    public String viewPost(@PathVariable("id") Long id, Model model) {
      Post post = postService.findById(id);
      model.addAttribute(post);
      return "post";
    
    }
    
    //create new post
    
    
    
    
    
}
