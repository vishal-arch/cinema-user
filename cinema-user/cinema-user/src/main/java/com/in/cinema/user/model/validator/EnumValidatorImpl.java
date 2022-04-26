package com.in.cinema.user.model.validator;

import com.in.cinema.user.model.Country;
import com.in.cinema.user.model.State;
import java.util.Arrays;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraintvalidation.SupportedValidationTarget;
import javax.validation.constraintvalidation.ValidationTarget;

@SupportedValidationTarget(ValidationTarget.ANNOTATED_ELEMENT)
public class EnumValidatorImpl implements ConstraintValidator<EnumValidator, Object> {

    private Class<? extends Enum> enumClass;

    @Override
    public void initialize(EnumValidator enumValidator) {
        this.enumClass = enumValidator.enumClass();
    }


    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {

        if (value == null) {
            return Boolean.TRUE;
        }

        if (value instanceof Country countryenum) {

        }


        if (enumClass.getTypeName().equals(State.class.getTypeName()))  {
            if(!validateStateEnum((String)value)){
                throw new IllegalArgumentException("Incorrect value of state value "+ value);
            }
        }


        return true;
    }

    private boolean validateStateEnum(String value) {

        return Arrays.stream(State.values())
            .anyMatch(state -> state.name().equals(value));

    }
}
