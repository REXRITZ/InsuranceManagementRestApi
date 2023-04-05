package com.platform.backend.dto;

import com.platform.backend.model.InsuranceType;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class InsurancePolicyRequest {

    @NotNull(message = "type cannot be empty")
    private InsuranceType type;

    @NotNull(message = "coverage amount cannot be null")
    @DecimalMin(value = "1", message = "Invalid amount")
    private BigDecimal coverageAmount;

    @NotNull(message = "premium cannot be null")
    @DecimalMin(value = "1", message = "Invalid amount")
    private BigDecimal premium;

    @NotNull(message = "start date cannot be null")
    @FutureOrPresent(message = "Start date must be in the present or future")
    private LocalDate startDate;

    @NotNull(message = "end date cannot be null")
    @Future(message = "End date must be in the future")
    private LocalDate endDate;

    private Long clientId;

    private Long claimId;

}
