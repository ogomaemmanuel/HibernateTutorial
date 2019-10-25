package com.ogoma.authserver.runners;

import com.ogoma.authserver.enitities.Client;
import com.ogoma.authserver.enitities.User;
import com.ogoma.authserver.services.ClientService;
import com.ogoma.authserver.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class DatabaseInitializer implements CommandLineRunner {
    @Autowired
    private UserService userService;

    @Autowired
    private Environment environment;
    @Autowired
    private ClientService clientService;

    @Override
    public void run(String... args) throws Exception {
        if (Stream.of(environment.getActiveProfiles())
                .anyMatch(x -> x.equalsIgnoreCase("dev"))) {
            if (userService.count() <= 0L) {
                User user = new User();
                user.setPassword("password");
                user.setEmail("user@test.com");
                user.setLastName("userLastName");
                user.setFirstName("userFirstName");
                user.setPhone("+254777778999999999");
                userService.save(user);
            }
            if (clientService.count() <= 0L) {
                Client client = new Client();
                client.setRedirectUri("http://localhost:8082/login");
                client.setAuthorizedGrantTypes("authorization_code,password,client_credentials,refresh_token");
                client.setClientSecret("secret");
                client.setAutoApprove("1");
                client.setId("75ed9571-541d-4829-8119-37ecf6ff9218");
                clientService.save(client);
            }
        }
    }
}
