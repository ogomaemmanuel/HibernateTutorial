package com.ogoma.authserver.unit.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ogoma.authserver.controllers.AuthController;
import com.ogoma.authserver.enitities.User;
import com.ogoma.authserver.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = AuthController.class)
public class UserControllerUnitTest {


    @Autowired
    MockMvc mockMvc;

    @MockBean
    UserService userService;
    @Autowired
    private ObjectMapper objectMapper;


    @BeforeEach
    public void setUp() {

    }

    @Test
    public void RegisterUserMethod() throws Exception {
        User testUser = new User();
        when(userService.save(any(User.class))).thenReturn(testUser);
        mockMvc.perform(post("/user/register").with(csrf().asHeader()).secure(true)
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(testUser)))
                .andExpect(status().isOk());
        verify(userService, times(1)).save(any(User.class));
    }
}
