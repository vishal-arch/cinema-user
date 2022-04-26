package com.in.cinema.user.cinemauser.business.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import com.in.cinema.user.business.entities.UserRegistration;
import com.in.cinema.user.business.repositories.UserRegistrationRepository;
import com.in.cinema.user.model.City;
import com.in.cinema.user.model.Country;
import com.in.cinema.user.model.State;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace= Replace.NONE)
public class UserRegistrationRepositoryTest {

    @Autowired
    private UserRegistrationRepository userRegistrationRepository;

    @Test
    void shouldSaveUserRegistration() {

        var ur = UserRegistration.builder()
            .emailId("AA@gmail.com")
            .mobileNumber("9898989898")
            .state(State.MAH)
            .city(City.MUM)
            .country(Country.IN)
            .build();

        var persistedObj = userRegistrationRepository.save(ur);
        assertThat(persistedObj).isNotNull();
        assertThat(persistedObj.getId()).isNotNull();

    }

    @Test
    void shouldGetUserRegistration(){

        var ur = UserRegistration.builder()
            .emailId("AA@gmail.com")
            .mobileNumber("9898989898")
            .state(State.MAH)
            .city(City.MUM)
            .country(Country.IN)
            .build();

        userRegistrationRepository.save(ur);

        assertThat(userRegistrationRepository.findAll().size()).isGreaterThan(0);



    }


}
