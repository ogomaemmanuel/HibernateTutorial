package com.ogoma.authserver.unit.services;

import com.ogoma.authserver.enitities.User;
import com.ogoma.authserver.repositories.UserRepository;
import com.ogoma.authserver.services.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

//use @RunWith in junit4
@ExtendWith(MockitoExtension.class)
public class UserServiceUnitTest {
    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserService userService;
    @Test
    public void testSaveUserMethod(){
        User user= new User();
        when(userRepository.save(any(User.class))).thenReturn(user);
        userService.save(user);
        verify(userRepository, times(1)).save(any(User.class));
    }
}
