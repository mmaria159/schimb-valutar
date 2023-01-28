package com.mariamacovei.exchange.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class EmployeeRequest {

    @NotBlank(message = "firstName is mandatory")
    private String firstName;
    @NotBlank(message = "lastName is mandatory")
    private String lastName;
    @NotBlank(message = "email is mandatory")
    @Email
    private String email;
    @NotBlank(message = "phone is mandatory")
    private String phone;
    @NotBlank(message = "function is mandatory")
    private String function;
}
