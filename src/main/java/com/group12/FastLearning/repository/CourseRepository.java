package com.group12.FastLearning.repository;

import com.group12.FastLearning.model.Course;
import com.group12.FastLearning.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {
    List<Course> findAll();
    Course findById (long id);
    List<Course> findByNameOrSubjectOrInstructorNameContainingIgnoreCase(String name, String subject, String instructorName);
}
