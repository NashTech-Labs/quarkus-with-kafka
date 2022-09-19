package com.knoldus.quarkus.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class Employee {

    @NotBlank(message = "First name cannot be null")
    private String firstName;
    private String lastName;
    @NotBlank(message = "Employee code cannot be null")
    private String empCode;

}
