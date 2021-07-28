package com.api.data.mapper;

import com.api.data.entity.EmployeeEntity;
import com.api.data.presentation.Employee;
import com.api.data.presentation.Employee.Meta;
import com.api.data.presentation.Employee.ObjectData;

import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper implements Mapper<EmployeeEntity, Employee> {

    @Override
    public EmployeeEntity toEntity(final Employee employee) {

        return EmployeeEntity.builder()
                             .name(employee.getData().getName())
                             .age(employee.getData().getAge())
                             .department(employee.getData().getDepartment())
                             .email(employee.getData().getEmail())
                             .build();
    }

    @Override
    public Employee toPresentation(final EmployeeEntity employeeEntity) {

        return Employee.builder()
                       .data(ObjectData.builder()
                                       .name(employeeEntity.getName())
                                       .age(employeeEntity.getAge())
                                       .department(employeeEntity.getDepartment())
                                       .email(employeeEntity.getEmail())
                                       .build())
                       ._meta(Meta.builder()
                                  .createdBy(employeeEntity.getCreatedBy())
                                  .lastModifiedBy(employeeEntity.getLastModifiedBy())
                                  .createdDate(employeeEntity.getCreatedDate())
                                  .lastModifiedDate(employeeEntity.getLastModifiedDate())
                                  .build())
                       .build();
    }
}
