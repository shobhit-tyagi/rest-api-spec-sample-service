package com.api.validator;

import com.api.data.entity.CompanyEntity;
import com.api.data.entity.EmployeeEntity;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class CompanyValidator implements Validator {

    @Override
    public boolean supports(final Class<?> clazz) {

        return CompanyEntity.class.equals(clazz);
    }

    @Override
    public void validate(final Object target, final Errors errors) {

    }
}
