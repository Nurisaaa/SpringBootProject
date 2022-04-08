package com.example.springbootproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.CascadeType.*;
import static javax.persistence.FetchType.EAGER;

@Entity
@Getter
@Setter
@Table(name = "teachers")
public class Teacher {
    @Id
    @SequenceGenerator(
            name = "teacher_sequence",
            sequenceName = "teacher_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "teacher_sequence")
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @JsonIgnore
    @OneToOne(cascade = {PERSIST, MERGE, DETACH, REFRESH},
            fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Course course;
    @OneToOne(cascade = {MERGE, REFRESH, PERSIST},
            orphanRemoval = true,
            fetch = EAGER)
    private AuthInfo authInfo;
}
