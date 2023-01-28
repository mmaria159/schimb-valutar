package com.mariamacovei.exchange.service;

import com.mariamacovei.exchange.dto.ClientRequest;
import com.mariamacovei.exchange.entity.Client;

public interface ClientService {
    Long addClient(ClientRequest clientRequest);
    Client findClient(Long id);
}
