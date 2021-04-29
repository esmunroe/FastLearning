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

   /*
    
    private Post() {
    
    }
    
    private Post(Long id, String title, String type, String caption, User author) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.link = link;
        this.caption = caption;
        this.author = author;
    }

    
    
    //getters and setters
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
   
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }
    
    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
    
    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }*/



    
}
