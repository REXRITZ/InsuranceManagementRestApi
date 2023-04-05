package com.platform.backend.service;

import com.platform.backend.dto.ApiResponse;
import com.platform.backend.dto.ClaimRequest;

public interface ClaimService {

    ApiResponse getAllClaims();
    ApiResponse getClaimById(Long claimId);
    ApiResponse addClaim(ClaimRequest claimRequest);
    ApiResponse deleteClaimById(Long claimId);
    ApiResponse updateClaim(Long claimId, ClaimRequest claimRequest);
}
