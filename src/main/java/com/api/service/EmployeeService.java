package com.api.service;

import com.api.data.presentation.Employee;
import com.api.data.presentation.Response;

import org.bson.types.ObjectId;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeService {

    Response<Employee> get(final ObjectId id, final ObjectId companyId, final List<String> fields);

    Response<List<Employee>> getAll(final ObjectId companyId, final List<String> fields, final String filter, final Pageable pageable);

    Response<Employee> post(final ObjectId id, final ObjectId companyId, final Employee company);

    Response<Employee> put(final ObjectId id, final ObjectId companyId, final Employee company);

    Response<Employee> patch(final ObjectId id, final ObjectId companyId, final Employee company);

    void delete(final ObjectId id, final ObjectId companyId);
}
