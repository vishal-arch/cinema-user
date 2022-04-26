package com.in.cinema.user.controller;

import com.in.cinema.user.business.services.UserService;
import com.in.cinema.user.model.UserRegistrationRequest;
import com.in.cinema.user.model.UserRegistrationResponse;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController implements UserApi {

    private final UserService userService;

    @Override
    public ResponseEntity<UserRegistrationResponse> registerUser(
        @Valid @RequestBody UserRegistrationRequest userRegistrationRequest) {

        var registrationResonse = userService.registerUser(userRegistrationRequest);
        var ur = UserRegistrationResponse.builder()
            .userRegistration(registrationResonse)
            .build();
        return new ResponseEntity<>(ur, HttpStatus.OK);
    }
}
