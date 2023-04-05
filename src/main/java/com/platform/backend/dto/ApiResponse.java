package com.platform.backend.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class ApiResponse {

    private Object data;
    private String message;
    private Integer status;

}
