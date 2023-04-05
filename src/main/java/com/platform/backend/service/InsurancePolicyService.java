package com.platform.backend.service;

import com.platform.backend.dto.ApiResponse;
import com.platform.backend.dto.InsurancePolicyRequest;

public interface InsurancePolicyService {

    ApiResponse getAllPolicies();
    ApiResponse getPolicyById(Long policyId);
    ApiResponse addPolicy(InsurancePolicyRequest policyRequest);
    ApiResponse deletePolicyById(Long policyId);
    ApiResponse updatePolicy(Long policyId, InsurancePolicyRequest policyRequest);
}
