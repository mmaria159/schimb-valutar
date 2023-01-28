package com.mariamacovei.exchange.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@RequiredArgsConstructor
public final class ClientRequest {
    @NotBlank(message = "firstName is mandatory")
    private final String firstName;
    @NotBlank(message = "lastName is mandatory")
    private final String lastName;
    @NotBlank(message = "email is mandatory")
    private final String email;
    @NotBlank(message = "phone is mandatory")
    private final String phone;
    @NotBlank(message = "idnp is mandatory")
    private final String idnp;
}
