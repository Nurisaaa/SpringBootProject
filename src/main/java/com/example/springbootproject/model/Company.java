package com.example.springbootproject.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

@Entity
@Getter
@Setter
@Table(name = "companies")
public class Company {

    @Id
    @SequenceGenerator(
            name = "company_sequence",
            sequenceName = "company_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "company_sequence")
    private Long id;
    private String name;
    @Column(name = "located_country")
    private String locatedCountry;

    @OneToMany(cascade = ALL,
            mappedBy = "company",
            fetch = FetchType.LAZY)
    private List<Course> courses;

}
