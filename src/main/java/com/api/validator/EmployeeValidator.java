package com.api.validator;

import com.api.data.entity.EmployeeEntity;
import com.api.data.presentation.Employee;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class EmployeeValidator implements Validator {

    @Override
    public boolean supports(final Class<?> clazz) {

        return EmployeeEntity.class.equals(clazz);
    }

    @Override
    public void validate(final Object target, final Errors errors) {

    }
}
