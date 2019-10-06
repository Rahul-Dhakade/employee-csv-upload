package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EmployeeDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
