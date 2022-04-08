package com.example.springbootproject.dto.request;

import com.example.springbootproject.enums.StudyFormat;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentRequest {
    private String firstName;
    private String lastName;
    private String email;
    private StudyFormat studyFormat;
    private String password;
}
