package com.ogoma.authserver.unit.repository;

import com.ogoma.authserver.AuthServerApplication;
import com.ogoma.authserver.enitities.Client;
import com.ogoma.authserver.repositories.ClientRepository;
import org.hamcrest.core.IsEqual;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import static org.hamcrest.MatcherAssert.assertThat;


@DataJpaTest
@ExtendWith(MockitoExtension.class)
@ContextConfiguration(classes = AuthServerApplication.class)
@ActiveProfiles("test")
public class ClientRepositoryUnitTest {
    @Autowired
    private ClientRepository clientRepository;

    @Test
    public void testSaveClient() {
        assertThat(clientRepository.findAll().size(), IsEqual.equalTo(0));
        Client client = new Client();
        client.setAccessTokenValidity(100);
        client.setScope("read");
        client.setRedirectUri("https://redirect.com");
        client.setAuthorities("test");
        Client client1 = clientRepository.save(client);

    }
}
