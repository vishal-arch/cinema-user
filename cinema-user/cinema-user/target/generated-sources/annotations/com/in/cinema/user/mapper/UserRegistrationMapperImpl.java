package com.in.cinema.user.mapper;

import com.in.cinema.user.business.entities.UserRegistration;
import com.in.cinema.user.business.entities.UserRegistration.UserRegistrationBuilder;
import com.in.cinema.user.model.City;
import com.in.cinema.user.model.Country;
import com.in.cinema.user.model.State;
import com.in.cinema.user.model.UserRegistrationRequest;
import java.util.UUID;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-24T16:45:15+0530",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
public class UserRegistrationMapperImpl implements UserRegistrationMapper {

    @Override
    public UserRegistration toUserRegistration(UserRegistrationRequest request) {
        if ( request == null ) {
            return null;
        }

        UserRegistrationBuilder userRegistration = UserRegistration.builder();

        userRegistration.mobileNumber( request.getMobileNumber() );
        userRegistration.emailId( request.getEmailId() );

        userRegistration.userRegistrationId( UUID.randomUUID() );
        userRegistration.state( State.valueOf(request.getState()) );
        userRegistration.country( Country.valueOf(request.getCountry()) );
        userRegistration.city( City.valueOf(request.getCity()) );

        return userRegistration.build();
    }
}
