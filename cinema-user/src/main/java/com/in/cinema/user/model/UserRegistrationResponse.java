package com.in.cinema.user.model;

import java.util.UUID;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserRegistrationResponse {

    private UUID userRegistration;

}
