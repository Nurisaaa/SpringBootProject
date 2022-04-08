package com.example.springbootproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.*;

@Entity
@Getter
@Setter
@Table(name = "groups")
public class Group {

    @Id
    @SequenceGenerator(
            name = "group_sequence",
            sequenceName = "group_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "group_sequence")

    private Long id;
    @Column(name = "group_name")
    private String name;
    @Column(name = "date_of_start")
    private String dateOfStart;
    @Column(name = "date_of_finis")
    private String dateOfFinish;
    @JsonIgnore
    @ManyToMany(cascade = {PERSIST, MERGE, REFRESH, DETACH}, fetch = FetchType.EAGER)
    @JoinTable(name = "course_group",
            joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Course> courses;

    @OneToMany(cascade = ALL,
            mappedBy = "group")
    private List<Student> students;

    public void setCourses(Course course) {
        if (courses == null) {
            courses = new ArrayList<>();
        }
        courses.add(course);
    }

}
