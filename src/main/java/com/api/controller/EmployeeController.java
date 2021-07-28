package com.api.controller;

import com.api.data.presentation.Employee;
import com.api.data.presentation.Response;
import com.api.service.EmployeeService;
import com.api.service.EmployeeService;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/companies/{companyId}/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/{id}")
    public Response<Employee> get(@PathVariable final ObjectId id,
                                  @PathVariable final ObjectId companyId,
                                  @RequestAttribute(required = false) final List<String> fields) {

        return employeeService.get(id, companyId, fields);
    }

    @GetMapping
    public Response<List<Employee>> getAll(@PathVariable final ObjectId companyId,
                                           @RequestAttribute(required = false) final List<String> fields,
                                           @RequestAttribute(required = false) final String filter,
                                           final Pageable pageable) {

        return employeeService.getAll(companyId, fields, filter, pageable);
    }

    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Response<Employee> post(@PathVariable final ObjectId id,
                                   @PathVariable final ObjectId companyId,
                                   @RequestBody final Employee employee) {

        return employeeService.post(id, companyId, employee);
    }

    @PutMapping("/{id}")
    public Response<Employee> put(@PathVariable final ObjectId id,
                                  @PathVariable final ObjectId companyId,
                                  @RequestBody final Employee employee) {

        return employeeService.put(id, companyId, employee);
    }

    @PatchMapping("/{id}")
    public Response<Employee> patch(@PathVariable final ObjectId id,
                                    @PathVariable final ObjectId companyId,
                                    @RequestBody final Employee employee) {

        return employeeService.patch(id, companyId, employee);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable final ObjectId id,
                       @PathVariable final ObjectId companyId) {

        employeeService.delete(id, companyId);
    }
}
