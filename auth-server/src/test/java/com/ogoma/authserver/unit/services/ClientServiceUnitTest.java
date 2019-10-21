package com.ogoma.authserver.unit.services;

import com.ogoma.authserver.enitities.Client;
import com.ogoma.authserver.repositories.ClientRepository;
import com.ogoma.authserver.services.ClientService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ClientServiceUnitTest {
    @Mock
    private ClientRepository clientRepository;
    @InjectMocks
    private ClientService clientService;
    @Test
    public void testSaveMethod() {
        Client testClient = new Client();
        when(clientRepository.save(any(Client.class))).thenReturn(testClient);
        clientService.save(testClient);
        verify(clientRepository, times(1)).save(testClient);
    }
}
