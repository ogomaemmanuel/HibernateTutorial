package com.ogoma.authserver.services;

import com.ogoma.authserver.enitities.Client;
import com.ogoma.authserver.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public Client save(Client client) {
      Client  savedClient = clientRepository.save(client);
        return savedClient;
    }
}
