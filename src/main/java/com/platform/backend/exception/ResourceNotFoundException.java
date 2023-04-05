package com.platform.backend.exception;

import com.platform.backend.dto.ApiResponse;
import org.springframework.http.HttpStatus;


public class ResourceNotFoundException extends RuntimeException{

    private final ApiResponse apiResponse;

    public ResourceNotFoundException(String message) {
        super(message);
        apiResponse = new ApiResponse(null, message, HttpStatus.NOT_FOUND.value());
    }

    public ApiResponse getApiResponse() {
        return apiResponse;
    }
}
