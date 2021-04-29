package com.group12.FastLearning.controller;


import com.group12.FastLearning.model.Course;
import com.group12.FastLearning.model.Post;
import com.group12.FastLearning.service.CourseService;
import com.group12.FastLearning.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private CourseService courseService;

    //show all posts
    @GetMapping("/posts")
    public String viewAll(Model model) {
        List<Post> posts = postService.findAll();
        model.addAttribute(posts);
        return "posts";
    }

    //show individual post
    @GetMapping("/posts/{id}")
    public String viewPost(@PathVariable("id") Long id, Model model) {
      Post post = postService.findById(id);
      model.addAttribute(post);
      return "post";
    }
    
    //create new post
    @PostMapping("/course/{id}/create")
    public String createPost(@PathVariable("id") Long id, Post post, Model model) {
        Course course = courseService.findById(id);
        List<Post> posts = course.getPosts();
        postService.createPost(posts, post);
        return "course/" + id;
    }
}
