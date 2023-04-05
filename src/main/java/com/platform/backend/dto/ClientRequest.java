package com.platform.backend.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ClientRequest {

    @NotEmpty(message = "name cannot be empty")
    private String name;

    @NotNull(message = "date of birth cannot be null")
    @Past(message = "please provide a valid date of birth")
    private LocalDate dob;

    @NotEmpty(message = "address cannot be empty")
    private String address;

    @NotEmpty(message = "email cannot be empty")
    @Email(message = "please enter a valid email")
    private String email;
}
