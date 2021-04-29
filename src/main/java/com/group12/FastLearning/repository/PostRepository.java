package com.group12.FastLearning.repository;

import com.group12.FastLearning.model.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {
   List<Post> findAll();
   Post findById(long id);
}
