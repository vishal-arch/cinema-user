package com.in.cinema.user.cinemauser.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.in.cinema.user.business.services.UserService;
import com.in.cinema.user.controller.UserController;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest(value = UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    void shouldRetrun200ForUserRegistration() throws Exception {

        String userRegistrationRequest = """
            {
                "mobileNumber": "9820420429",
                "emailId":"v@gmail.com",
                "country":"IN",
                "state":"MAH",
                "city":"MUM"
            }
            """;

        when(userService.registerUser(any())).thenReturn(UUID.randomUUID());

        RequestBuilder builder = MockMvcRequestBuilders.post("/v1/cinema/user/registration")
            .content(userRegistrationRequest)
            .accept(MediaType.APPLICATION_JSON)
            .contentType(MediaType.APPLICATION_JSON);
        var response = mockMvc.perform(builder).andReturn();
        assertThat(response.getResponse().getStatus()).isEqualTo(HttpStatus.OK.value());

    }

}
