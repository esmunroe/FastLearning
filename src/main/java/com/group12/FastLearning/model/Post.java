package com.group12.FastLearning.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "post_id")
    private Long id;

    @CreationTimestamp
    private Date creationDate;
   
    
    @NotEmpty(message = "Please provide a title for your post")
    private String title;
    
    @NotEmpty(message = "Please provide a resource type")
    private String type;
    
    @NotEmpty(message = "Please provide a source link")
    private String link;
    
    @NotEmpty(message = "Please provide a caption")
    private String caption;
    
    //what goes here?
    private User author;

  
    
}
