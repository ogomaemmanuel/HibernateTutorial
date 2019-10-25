package com.ogoma.authserver.services;

import com.ogoma.authserver.enitities.Client;
import com.ogoma.authserver.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public Client save(Client client) {
        if(client.getId()==null){
            client.setId(UUID.randomUUID().toString());
        }
        Client  savedClient = clientRepository.save(client);
        return savedClient;
    }
    public Long count(){
      return   clientRepository.count();
    }
}
