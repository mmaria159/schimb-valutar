package com.mariamacovei.exchange.service;

import com.mariamacovei.exchange.dto.ClientRequest;
import com.mariamacovei.exchange.entity.Client;
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

}
