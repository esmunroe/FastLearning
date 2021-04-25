package com.group12.FastLearning.controller;

import com.group12.FastLearning.model.Course;
import com.group12.FastLearning.model.User;
import com.group12.FastLearning.service.CourseService;
import com.group12.FastLearning.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@ControllerAdvice
public class CourseController {
    @Autowired
    CourseService courseService;

    @Autowired
    UserService userService;

    @ModelAttribute("loggedInUser")
    public User loggedInUser(){
        return userService.getLoggedInUser();
    }

    @ModelAttribute("subscriptions")
    public List<Course> subscriptions(){
        User user = loggedInUser();
        if (user == null) return null;
        return user.getSubscribedCourses();
    }

    @PostMapping("/subscriptions")
    public String addSubscription(@RequestParam long id, HttpServletRequest request){
        User user = loggedInUser();
        Course course = courseService.findById(id);
        List<Course> courses = user.getSubscribedCourses();
        courses.add(course);
        userService.updateSubscriptions(subscriptions());
        return "redirect:" + request.getHeader("Referer");
    }

    @DeleteMapping("/subscriptions")
    public String removeSubscription(@RequestParam long id, HttpServletRequest request){
        User user = loggedInUser();
        Course course = courseService.findById(id);
        List<Course> courses = user.getSubscribedCourses();
        courses.remove(course);
        userService.updateSubscriptions(subscriptions());
        return "redirect:" + request.getHeader("Referer");
    }

    @GetMapping(value = "/course/{id}")
    public String showCourse(@PathVariable int id, Model model){
        Course course = courseService.findById(id);
        model.addAttribute(course);
        return "course";
    }

    @RequestMapping(value = "/results")
    public String search(@Param("query") String query, Model model){
        List<Course> courses = courseService.findByCourse(query);
        model.addAttribute("results", courses);
        model.addAttribute("query", query);
        return "index";
    }
}
