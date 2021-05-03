package com.group12.FastLearning.service;

import com.group12.FastLearning.model.Course;
import com.group12.FastLearning.model.Post;
import com.group12.FastLearning.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;
    
    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> findAll(){
        return postRepository.findAll();
    }

    public List<Post> findAllByCourse(Course course) {
        return postRepository.findAllByCourse(course);
    }

    public void save(Post post){
        postRepository.save(post);
    }
}
