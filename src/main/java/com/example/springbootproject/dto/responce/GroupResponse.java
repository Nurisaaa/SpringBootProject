package com.example.springbootproject.dto.responce;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class GroupResponse {
    private Long id;
    private String name;
    private String dateOfStart;
    private String dateOfFinish;
}
