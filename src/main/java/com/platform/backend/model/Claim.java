package com.platform.backend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "claim")
public class Claim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "claim_number")
    private Long claimNumber;

    @Column(name = "description")
    private String description;

    @Column(name = "claim_date")
    private LocalDate claimDate;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "claim_status")
    private ClaimStatus claimStatus;

    @OneToOne(mappedBy = "claim", fetch = FetchType.LAZY)
    private InsurancePolicy policy;

    public Claim(
            String description,
            LocalDate claimDate,
            ClaimStatus claimStatus
    ) {
        this.description = description;
        this.claimDate = claimDate;
        this.claimStatus = claimStatus;
    }
}
