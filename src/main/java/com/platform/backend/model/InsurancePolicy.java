package com.platform.backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "insurance_policy")
public class InsurancePolicy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "policy_number")
    private Long policyNumber;

    @Column(name = "type")
    @Enumerated(EnumType.ORDINAL)
    private InsuranceType type;

    @Column(name = "coverage_amount")
    private BigDecimal coverageAmount;

    @Column(name = "premium")
    private BigDecimal premium;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "claim_id", unique = true)
    private Claim claim;


    public InsurancePolicy(
            InsuranceType type,
            BigDecimal coverageAmount,
            BigDecimal premium,
            LocalDate startDate,
            LocalDate endDate
    ) {
        this.type = type;
        this.coverageAmount = coverageAmount;
        this.premium = premium;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
