package com.example.springbootproject.model;

import com.example.springbootproject.enums.StudyFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.CascadeType.*;

@Entity
@Data
@Getter
@Setter
@Table(name = "students")
public class Student {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "student_sequence")
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String email;
    @Enumerated
    @Column(name = "study_format")
    private StudyFormat studyFormat;
    @JsonIgnore
    @ManyToOne(cascade = {PERSIST, MERGE, DETACH, REFRESH})
    @JoinColumn(name = "group_id")
    private Group group;
}
