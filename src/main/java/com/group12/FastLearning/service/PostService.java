package com.group12.FastLearning.service;

import com.group12.FastLearning.model.Post;
import com.group12.FastLearning.model.Course;
import com.group12.FastLearning.model.Role;
import com.group12.FastLearning.model.User;
import com.group12.FastLearning.repository.RoleRepository;
import com.group12.FastLearning.repository.UserRepository;
import com.group12.FastLearning.repository.CourseRepository;
import com.group12.FastLearning.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
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
    
    public Post findById(long id){
        return postRepository.findById(id);
    }
    
    
    
    public Post createNew(Post post) {
    
      //?
   
    }
    
    public Post deletePost(Post post) {
    
      //?
    
    }

}
