package com.in.cinema.user.business.services;

import com.in.cinema.user.business.repositories.UserRegistrationRepository;
import com.in.cinema.user.mapper.UserRegistrationMapper;
import com.in.cinema.user.model.UserRegistrationRequest;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRegistrationRepository userRegistrationRepository;

    public UUID registerUser(UserRegistrationRequest userRegistrationRequest) {

        var userRegistration = UserRegistrationMapper.mapper.toUserRegistration(userRegistrationRequest);
        var userRegistrationId = userRegistrationRepository.save(userRegistration);
        return userRegistrationId.getUserRegistrationId();

    }

}
