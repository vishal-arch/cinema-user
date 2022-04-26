package com.in.cinema.user.mapper;

import com.in.cinema.user.business.entities.UserRegistration;
import com.in.cinema.user.model.City;
import com.in.cinema.user.model.Country;
import com.in.cinema.user.model.State;
import com.in.cinema.user.model.UserRegistrationRequest;
import java.util.UUID;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(imports = {UUID.class, Country.class, State.class, City.class})
public interface UserRegistrationMapper {

    UserRegistrationMapper mapper = Mappers.getMapper(UserRegistrationMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "userRegistrationId", expression = "java(UUID.randomUUID())")
    @Mapping(target = "state",expression = "java(State.valueOf(request.getState()))")
    @Mapping(target = "country",expression = "java(Country.valueOf(request.getCountry()))")
    @Mapping(target = "city",expression = "java(City.valueOf(request.getCity()))")
    UserRegistration toUserRegistration(UserRegistrationRequest request);
}
