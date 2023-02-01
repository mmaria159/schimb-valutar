package com.mariamacovei.exchange.service;

import com.mariamacovei.exchange.dto.ClientRequest;
import com.mariamacovei.exchange.entity.Client;
import com.mariamacovei.exchange.exception.ClientNotFoundException;
import com.mariamacovei.exchange.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;

    @Override
    public Long addClient(ClientRequest request) {
        Client client = new Client(
                request.getFirstName(),
                request.getLastName(),
                request.getEmail(),
                request.getPhone(),
                request.getIdnp());

        return clientRepository.save(client).getId();
    }

    @Override
    public Client findClient(Long id) {
        return clientRepository.findById(id).orElseThrow(() ->
                new ClientNotFoundException("Client with id " + id + " wasn't found"));
    }

    @Override
    public Long updateClient(Long clientId, ClientRequest clientRequest) {
        Client client = clientRepository.findById(clientId).orElseThrow(() ->
                new ClientNotFoundException("Client with id " + clientId + " wasn't found"));
        Client newClient = new Client(
                client.getId(),
                clientRequest.getFirstName(),
                clientRequest.getLastName(),
                clientRequest.getEmail(),
                clientRequest.getPhone(),
                clientRequest.getIdnp());

        clientRepository.save(newClient);

        return newClient.getId();
    }


}

