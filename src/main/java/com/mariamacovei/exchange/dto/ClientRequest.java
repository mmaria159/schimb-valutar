package com.mariamacovei.exchange.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@RequiredArgsConstructor
public class ClientRequest {
    @NotBlank(message = "firstName is mandatory")
    private String firstName;
    @NotBlank(message = "lastName is mandatory")
    private String lastName;
    @NotBlank(message = "email is mandatory")
    private String email;
    @NotBlank(message = "phone is mandatory")
    private String phone;
    @NotBlank(message = "idnp is mandatory")
    private String idnp;
}
