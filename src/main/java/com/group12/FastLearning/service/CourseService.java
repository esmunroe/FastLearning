package com.group12.FastLearning.service;

import com.group12.FastLearning.model.Course;
import com.group12.FastLearning.model.User;
import com.group12.FastLearning.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public List<Course> findAll(){
        return courseRepository.findAll();
    }

    public Course findById(long id){
        return courseRepository.findById(id);
    }

    public List<Course> findByCourse(String query){
        return courseRepository.findByNameOrSubjectOrInstructorNameContainingIgnoreCase(query, query, query);
    }
}
