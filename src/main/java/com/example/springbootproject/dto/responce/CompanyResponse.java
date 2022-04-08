package com.example.springbootproject.dto.responce;

import com.example.springbootproject.model.Course;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CompanyResponse {
    private Long id;
    private String name;
    private String locatedCountry;

}
