package com.platform.backend.controller;

import com.platform.backend.dto.ApiResponse;
import com.platform.backend.dto.InsurancePolicyRequest;
import com.platform.backend.service.InsurancePolicyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/policies")
public class InsurancePolicyController {

    @Autowired
    private InsurancePolicyService policyService;

    @GetMapping
    private ResponseEntity<ApiResponse> getAllPolicies() {
        return new ResponseEntity<>(policyService.getAllPolicies(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    private ResponseEntity<ApiResponse> getPolicyById(
            @PathVariable(name = "id") Long policyId
    ) {
        return new ResponseEntity<>(policyService.getPolicyById(policyId), HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<ApiResponse> createPolicy(
            @Valid @RequestBody InsurancePolicyRequest policyRequest
    ) {
        return new ResponseEntity<>(policyService.addPolicy(policyRequest), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    private ResponseEntity<ApiResponse> updatePolicyById(
            @PathVariable(name = "id") Long policyId,
            @Valid @RequestBody InsurancePolicyRequest policyRequest
    ) {
        return new ResponseEntity<>(
                policyService.updatePolicy(policyId, policyRequest),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<ApiResponse> deletePolicyById(
            @PathVariable(name = "id") Long policyId
    ) {
        return new ResponseEntity<>(policyService.deletePolicyById(policyId), HttpStatus.OK);
    }
}
