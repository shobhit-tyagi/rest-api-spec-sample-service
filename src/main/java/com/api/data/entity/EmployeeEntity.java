package com.api.data.entity;

import lombok.Builder;
import lombok.Data;

import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(collection = "employee")
public class EmployeeEntity extends CommonEntity {

    private String name;
    private String email;
    private int age;
    private String department;
}
