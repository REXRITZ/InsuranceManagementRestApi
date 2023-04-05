package com.platform.backend.service.impl;

import com.platform.backend.dto.ApiResponse;
import com.platform.backend.dto.ClaimRequest;
import com.platform.backend.exception.ResourceNotFoundException;
import com.platform.backend.model.Claim;
import com.platform.backend.repository.ClaimRepository;
import com.platform.backend.service.ClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ClaimServiceImpl implements ClaimService {

    @Autowired
    private ClaimRepository claimRepository;

    @Override
    public ApiResponse getAllClaims() {
        return new ApiResponse(
                claimRepository.findAll(),
                HttpStatus.OK.getReasonPhrase(),
                HttpStatus.OK.value()
        );
    }

    @Override
    public ApiResponse getClaimById(Long claimId) {
        Claim claim = claimRepository.findById(claimId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Claim with given id does not exist")
                );
        return new ApiResponse(
                claim,
                HttpStatus.OK.getReasonPhrase(),
                HttpStatus.OK.value()
        );
    }

    @Override
    public ApiResponse addClaim(ClaimRequest claimRequest) {
        Claim claim = new Claim(
                claimRequest.getDescription(),
                claimRequest.getClaimDate(),
                claimRequest.getClaimStatus()
        );
        return new ApiResponse(
                claimRepository.save(claim),
                "Record created successfully",
                HttpStatus.CREATED.value()
        );
    }

    @Override
    public ApiResponse deleteClaimById(Long claimId) {
        ApiResponse apiResponse = getClaimById(claimId);
        apiResponse.setData(null);
        return apiResponse;
    }

    @Override
    public ApiResponse updateClaim(Long claimId, ClaimRequest claimRequest) {
        ApiResponse apiResponse = getClaimById(claimId);
        Claim claim = (Claim) apiResponse.getData();
        claim.setDescription(claimRequest.getDescription());
        claim.setClaimDate(claimRequest.getClaimDate());
        claim.setClaimStatus(claimRequest.getClaimStatus());
        return new ApiResponse(
                claimRepository.save(claim),
                "Record updated successfully",
                HttpStatus.OK.value()
        );
    }
}
