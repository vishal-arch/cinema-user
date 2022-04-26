package com.in.cinema.user.cinemauser.business.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.in.cinema.user.business.entities.UserRegistration;
import com.in.cinema.user.business.repositories.UserRegistrationRepository;
import com.in.cinema.user.business.services.UserService;
import com.in.cinema.user.model.City;
import com.in.cinema.user.model.Country;
import com.in.cinema.user.model.State;
import com.in.cinema.user.model.UserRegistrationRequest;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    private UserService userService;

    @Mock
    private UserRegistrationRepository userRegistrationRepository;

    @BeforeEach
    void setUp(){
        userService = new UserService(userRegistrationRepository);
    }

    @Test
    public void shouldRegisterUser() {

        when(userRegistrationRepository.save(any())).thenReturn(UserRegistration.builder()
            .userRegistrationId(UUID.randomUUID())
            .build());

        var userRegistrationRequest = new UserRegistrationRequest();
        userRegistrationRequest.setCity(City.MUM.name());
        userRegistrationRequest.setCountry(Country.IN.name());
        userRegistrationRequest.setState(State.MAH.name());
        userRegistrationRequest.setMobileNumber("0000000");
        userRegistrationRequest.setEmailId("AA@g.com");

        UUID userRegistration = userService.registerUser(userRegistrationRequest);
        assertThat(userRegistration).isNotNull();
    }


}
