package com.in.cinema.user.controller;

import com.in.cinema.user.model.UserRegistrationRequest;
import com.in.cinema.user.model.UserRegistrationResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/v1/cinema/user")
public interface UserApi {

    @PostMapping("/registration")
    ResponseEntity<UserRegistrationResponse> registerUser(UserRegistrationRequest userRegistrationRequest);

}
