package com.api.service;

import com.api.dao.CompanyDao;
import com.api.dao.EmployeeDao;
import com.api.data.mapper.EmployeeMapper;
import com.api.data.presentation.Employee;
import com.api.data.presentation.Response;
import com.api.utils.CriteriaBuilder;
import com.api.utils.QueryBuilder;
import com.api.validator.EmployeeValidator;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.val;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private EmployeeValidator employeeValidator;

    @Override
    public Response<Employee> get(final ObjectId id, final ObjectId companyId, final List<String> fields) {

        return null;
    }

    @Override
    public Response<List<Employee>> getAll(final ObjectId companyId, final List<String> fields, final String filter, final Pageable pageable) {

        return null;
    }

    @Override
    public Response<Employee> post(final ObjectId id, final ObjectId companyId, final Employee company) {

        return null;
    }

    @Override
    public Response<Employee> put(final ObjectId id, final ObjectId companyId, final Employee company) {

        return null;
    }

    @Override
    public Response<Employee> patch(final ObjectId id, final ObjectId companyId, final Employee company) {

        return null;
    }

    @Override
    public void delete(final ObjectId id, final ObjectId companyId) {

    }
}
