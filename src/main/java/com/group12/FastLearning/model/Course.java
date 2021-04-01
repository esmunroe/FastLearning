package com.group12.FastLearning.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "course_id")
    private Long id;

    private String name;
    private String subject;
    private String instructorName;

    @ManyToMany (fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private List<User> moderators;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private List<Post> posts;
}
