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

@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private CourseService courseService;

    @GetMapping(value = "/course/{id}/create")
    public String getPostForm(@PathVariable("id") Long id, Model model){
        Course course = courseService.findById(id);
        model.addAttribute("post", new Post());
        model.addAttribute("course", course);
        return "submit";
    }

    @PostMapping("/course/{id}/create")
    public String createPost(@PathVariable("id") Long id, Post post, Model model) {
        Course course = courseService.findById(id);
        post.setCourse(course);
        postService.save(post);
        model.addAttribute("course", course);
        model.addAttribute("success", "Post has been added to course.");
        model.addAttribute("post", new Post());
        return "success";
    }
}
