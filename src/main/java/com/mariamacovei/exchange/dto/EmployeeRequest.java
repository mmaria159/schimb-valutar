package com.mariamacovei.exchange.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@RequiredArgsConstructor
public final class EmployeeRequest {

    @NotBlank(message = "firstName is mandatory")
    private final String firstName;
    @NotBlank(message = "lastName is mandatory")
    private final String lastName;
    @NotBlank(message = "email is mandatory")
    @Email
    private final String email;
    @NotBlank(message = "phone is mandatory")
    private final String phone;
    @NotBlank(message = "function is mandatory")
    private final String function;
}
