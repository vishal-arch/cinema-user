package com.in.cinema.user.cinemauser.controller;

import static org.assertj.core.api.Assertions.assertThat;

import com.in.cinema.user.business.services.UserService;
import com.in.cinema.user.model.City;
import com.in.cinema.user.model.Country;
import com.in.cinema.user.model.State;
import com.in.cinema.user.model.UserRegistrationRequest;
import java.net.URI;
import java.net.URISyntaxException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class UserControllerIntegrationTest {

    @Autowired
    protected TestRestTemplate restTemplate;

    @Test
    void shouldReturn200() throws URISyntaxException {


        var userRegistrationRequest = new UserRegistrationRequest();
        userRegistrationRequest.setCity(City.MUM.name());
        userRegistrationRequest.setCountry(Country.IN.name());
        userRegistrationRequest.setState(State.MAH.name());
        userRegistrationRequest.setMobileNumber("0000000");
        userRegistrationRequest.setEmailId("AA@g.com");

        HttpEntity<UserRegistrationRequest> req = new HttpEntity(userRegistrationRequest,null);
        var response = restTemplate.postForEntity(new URI("/v1/cinema/user/registration"),req,UserRegistrationRequest.class);

        assertThat(response.getStatusCode().value()).isEqualTo(200);


    }

}
