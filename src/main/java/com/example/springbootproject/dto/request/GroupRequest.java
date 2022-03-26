package com.example.springbootproject.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GroupRequest {
    private String name;
    private String dateOfStart;
    private String dateOfFinish;
}
