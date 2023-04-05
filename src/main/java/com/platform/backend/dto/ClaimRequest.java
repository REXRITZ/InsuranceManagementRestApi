package com.platform.backend.dto;

import com.platform.backend.model.ClaimStatus;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ClaimRequest {

    @NotEmpty(message = "description cannot be empty")
    private String description;

    @Future(message = "claim date must be in the future")
    private LocalDate claimDate;

    @NotNull(message = "status cannot be empty")
    private ClaimStatus claimStatus;

}
