package com.example.springbootproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.CascadeType.*;

@Entity
@Getter
@Setter
@Table(name = "courses")
public class Course {
    @Id
    @SequenceGenerator(
            name = "course_sequence",
            sequenceName = "course_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "course_sequence")
    private Long id;
    private String name;
    private String duration;

    @JsonIgnore
    @ManyToOne(cascade = {MERGE, DETACH, PERSIST, REFRESH},
            fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;

    @OneToOne(cascade = {MERGE, PERSIST, DETACH, REFRESH, REMOVE},
            mappedBy = "course")
    private Teacher teacher;

    @ManyToMany(cascade = {MERGE, REFRESH, DETACH, PERSIST, REMOVE},
            fetch = FetchType.LAZY)
    @JoinTable(name = "course_group"
            , joinColumns = @JoinColumn(name = "course_id")
            , inverseJoinColumns = @JoinColumn(name = "group_id"))
    private List<Group> group;

}
