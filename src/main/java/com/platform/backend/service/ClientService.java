package com.platform.backend.service;

import com.platform.backend.dto.ApiResponse;
import com.platform.backend.dto.ClientRequest;

public interface ClientService {

    ApiResponse getAllClients();
    ApiResponse getClientById(Long clientId);
    ApiResponse addClient(ClientRequest clientRequest);
    ApiResponse deleteClientById(Long clientId);
    ApiResponse updateClient(Long clientId, ClientRequest clientRequest);
}
