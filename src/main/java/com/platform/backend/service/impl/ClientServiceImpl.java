package com.platform.backend.service.impl;

import com.platform.backend.dto.ApiResponse;
import com.platform.backend.exception.ResourceNotFoundException;
import com.platform.backend.model.Client;
import com.platform.backend.dto.ClientRequest;
import com.platform.backend.repository.ClientRepository;
import com.platform.backend.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public ApiResponse getAllClients() {
        return new ApiResponse(
                clientRepository.findAll(),
                HttpStatus.OK.getReasonPhrase(),
                HttpStatus.OK.value()
        );
    }

    @Override
    public ApiResponse getClientById(Long clientId) {
        Client client= clientRepository.findById(clientId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Client with given id does not exist")
                );
        return new ApiResponse(
                client,
                HttpStatus.OK.getReasonPhrase(),
                HttpStatus.OK.value()
        );
    }

    @Override
    public ApiResponse addClient(ClientRequest clientRequest) {
        Client client = new Client(
                clientRequest.getName(),
                clientRequest.getDob(),
                clientRequest.getAddress(),
                clientRequest.getEmail()
        );
        return new ApiResponse(
                clientRepository.save(client),
                "Record added successfully",
                HttpStatus.CREATED.value()
        );
    }

    @Override
    public ApiResponse updateClient(Long clientId, ClientRequest clientRequest) {
        ApiResponse apiResponse = getClientById(clientId);
        Client client = (Client) apiResponse.getData();
        client.setName(clientRequest.getName());
        client.setAddress(clientRequest.getAddress());
        client.setEmail(clientRequest.getEmail());
        client.setDateOfBirth(clientRequest.getDob());
        return new ApiResponse(
                clientRepository.save(client),
                "Record updated successfully",
                HttpStatus.OK.value()
        );
    }

    @Override
    public ApiResponse deleteClientById(Long clientId) {
        ApiResponse apiResponse = getClientById(clientId);
        clientRepository.deleteById(clientId);
        apiResponse.setData(null);
        return apiResponse;
    }
}
