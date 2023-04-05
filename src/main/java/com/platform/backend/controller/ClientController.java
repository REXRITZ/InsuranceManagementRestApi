package com.platform.backend.controller;

import com.platform.backend.dto.ApiResponse;
import com.platform.backend.dto.ClientRequest;
import com.platform.backend.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    private ResponseEntity<ApiResponse> getAllClients() {
        return new ResponseEntity<>(clientService.getAllClients(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    private ResponseEntity<ApiResponse> getClientById(
            @PathVariable(name = "id") Long clientId
    ) {
        return new ResponseEntity<>(clientService.getClientById(clientId), HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<ApiResponse> createClient(
            @Valid @RequestBody ClientRequest clientRequest
    ) {
        return new ResponseEntity<>(clientService.addClient(clientRequest), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    private ResponseEntity<ApiResponse> updateClientById(
            @PathVariable(name = "id") Long clientId,
            @Valid @RequestBody ClientRequest clientRequest
    ) {
        return new ResponseEntity<>(
                clientService.updateClient(clientId, clientRequest),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<ApiResponse> deleteClientById(
            @PathVariable(name = "id") Long clientId
    ) {
        return new ResponseEntity<>(clientService.deleteClientById(clientId), HttpStatus.OK);
    }

}
