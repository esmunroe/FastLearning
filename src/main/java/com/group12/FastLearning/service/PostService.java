package com.group12.FastLearning.service;

import com.group12.FastLearning.model.Post;
import com.group12.FastLearning.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    
    public Post findById(long id) {
        return postRepository.findById(id);
    }

    public List<Post> createPost(List<Post> posts, Post post) {
        post.setTitle(post.getTitle());
        post.setType(post.getType());
        post.setLink(post.getLink());
        post.setCaption(post.getCaption());
        postRepository.save(post);
        posts.add(post);
        return posts;
    }
}
