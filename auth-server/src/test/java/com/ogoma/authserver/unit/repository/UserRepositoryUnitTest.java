package com.ogoma.authserver.unit.repository;

import com.ogoma.authserver.AuthServerApplication;
import com.ogoma.authserver.enitities.User;
import com.ogoma.authserver.repositories.UserRepository;
import org.hamcrest.core.IsEqual;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@DataJpaTest
@ContextConfiguration(classes = AuthServerApplication.class)
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
public class UserRepositoryUnitTest {
    @Autowired
    private UserRepository userRepository;
    @Test
    public void testSaveUser(){
        assertThat(userRepository.findAll().size(), IsEqual.equalTo(0));
        User chama = new User();
        chama.setEmail("test@gmail.com");
        chama.setFirstName("Test accountNO");
        chama.setLastName("test setDescription");
        chama.setPassword("1788");
        userRepository.save(chama);
        assertThat(userRepository.findAll().size(), IsEqual.equalTo(1));
    }
}
