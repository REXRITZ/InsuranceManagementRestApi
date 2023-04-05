package com.platform.backend.service.impl;

import com.platform.backend.dto.ApiResponse;
import com.platform.backend.dto.InsurancePolicyRequest;
import com.platform.backend.exception.ResourceNotFoundException;
import com.platform.backend.model.Claim;
import com.platform.backend.model.Client;
import com.platform.backend.model.InsurancePolicy;
import com.platform.backend.repository.ClaimRepository;
import com.platform.backend.repository.ClientRepository;
import com.platform.backend.repository.InsurancePolicyRepository;
import com.platform.backend.service.InsurancePolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class InsurancePolicyImpl implements InsurancePolicyService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ClaimRepository claimRepository;

    @Autowired
    private InsurancePolicyRepository policyRepository;

    @Override
    public ApiResponse getAllPolicies() {
        return new ApiResponse(
                policyRepository.findAll(),
                HttpStatus.OK.getReasonPhrase(),
                HttpStatus.OK.value()
        );
    }

    @Override
    public ApiResponse getPolicyById(Long policyId) {
        InsurancePolicy policy = policyRepository.findById(policyId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Insurance policy with given id does not exist")
                );
        return new ApiResponse(
                policy,
                HttpStatus.OK.getReasonPhrase(),
                HttpStatus.OK.value()
        );
    }

    @Override
    public ApiResponse addPolicy(InsurancePolicyRequest policyRequest) {
        Client client = null;
        Claim claim = null;
        if(policyRequest.getClientId() != null) {
            client = clientRepository.findById(policyRequest.getClientId())
                    .orElseThrow(() ->
                            new ResourceNotFoundException("Client with given id does not exist")
                    );
        }
        if (policyRequest.getClaimId() != null) {
            claim = claimRepository.findById(policyRequest.getClaimId())
                    .orElseThrow(() ->
                            new ResourceNotFoundException("Claim with given id does not exist")
                    );
        }
        InsurancePolicy policy = new InsurancePolicy(
                policyRequest.getType(),
                policyRequest.getCoverageAmount(),
                policyRequest.getPremium(),
                policyRequest.getStartDate(),
                policyRequest.getEndDate()
        );
        policy.setClient(client);
        policy.setClaim(claim);

        return new ApiResponse(
                policyRepository.save(policy),
                "Record added successfully",
                HttpStatus.CREATED.value()
        );
    }

    @Override
    public ApiResponse deletePolicyById(Long policyId) {
        ApiResponse apiResponse = getPolicyById(policyId);
        policyRepository.deleteById(policyId);
        apiResponse.setData(null);
        return apiResponse;
    }

    @Override
    public ApiResponse updatePolicy(Long policyId, InsurancePolicyRequest policyRequest) {
        ApiResponse apiResponse = getPolicyById(policyId);
        InsurancePolicy policy = (InsurancePolicy) apiResponse.getData();
        policy.setType(policyRequest.getType());
        policy.setCoverageAmount(policyRequest.getCoverageAmount());
        policy.setPremium(policyRequest.getPremium());
        policy.setStartDate(policyRequest.getStartDate());
        policy.setEndDate(policyRequest.getEndDate());

        return new ApiResponse(
                policyRepository.save(policy),
                "Record updated successfully",
                HttpStatus.OK.value()
        );
    }

}
