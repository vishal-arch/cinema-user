package com.in.cinema.user.model;

import com.in.cinema.user.model.validator.EnumValidator;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class User {

    @NotNull
    private String mobileNumber;
    @NotNull
    @Email
    private String emailId;
    @EnumValidator(enumClass = State.class)
    private String state;
    private String city;
    private String country;
    private UserStatus status;

}
