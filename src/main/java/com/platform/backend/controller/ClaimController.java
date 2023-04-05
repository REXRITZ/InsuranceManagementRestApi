package com.platform.backend.controller;

import com.platform.backend.dto.ApiResponse;
import com.platform.backend.dto.ClaimRequest;
import com.platform.backend.service.ClaimService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/claims")
public class ClaimController {

    @Autowired
    private ClaimService claimService;

    @GetMapping
    private ResponseEntity<ApiResponse> getAllClaims() {
        return new ResponseEntity<>(claimService.getAllClaims(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    private ResponseEntity<ApiResponse> getClaimById(
            @PathVariable(name = "id") Long claimId
    ) {
        return new ResponseEntity<>(claimService.getClaimById(claimId), HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<ApiResponse> createClaim(
            @Valid @RequestBody ClaimRequest claimRequest
    ) {
        return new ResponseEntity<>(claimService.addClaim(claimRequest), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    private ResponseEntity<ApiResponse> updateClaimById(
            @PathVariable(name = "id") Long claimId,
            @Valid @RequestBody ClaimRequest claimRequest
    ) {
        return new ResponseEntity<>(
                claimService.updateClaim(claimId, claimRequest),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<ApiResponse> deleteClaimById(
            @PathVariable(name = "id") Long claimId
    ) {
        return new ResponseEntity<>(claimService.deleteClaimById(claimId), HttpStatus.OK);
    }
}
