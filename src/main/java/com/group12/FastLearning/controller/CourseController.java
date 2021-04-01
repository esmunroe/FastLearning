package com.group12.FastLearning.controller;

import com.group12.FastLearning.model.Course;
import com.group12.FastLearning.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@ControllerAdvice
public class CourseController {
    @Autowired
    CourseService courseService;

    @GetMapping(value = "/course/{id}")
    public String showCourse(@PathVariable int id, Model model){
        Course course = courseService.findById(id);
        model.addAttribute(course);
        return "course";
    }

    @RequestMapping(value = "/results")
    public String search(@Param("query") String query, Model model){
        List<Course> courses = courseService.findByCourse(query);
        model.addAttribute("searchResults", courses);
        model.addAttribute("query", query);
        return "results";
    }
}
