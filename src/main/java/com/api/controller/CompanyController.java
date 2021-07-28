package com.api.controller;

import com.api.data.presentation.Company;
import com.api.data.presentation.Response;
import com.api.service.CompanyService;

import lombok.NoArgsConstructor;
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
@RequestMapping("/api/companies")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping("/{id}")
    public Response<Company> get(@PathVariable final ObjectId id,
                                 @RequestAttribute(required = false) final List<String> fields) {

        return companyService.get(id, fields);
    }

    @GetMapping
    public Response<List<Company>> getAll(@RequestAttribute(required = false) final List<String> fields,
                                          @RequestAttribute(required = false) final String filter,
                                          final Pageable pageable) {

        return companyService.getAll(fields, filter, pageable);
    }

    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Response<Company> post(@PathVariable final ObjectId id,
                                  @RequestBody final Company company) {

        return companyService.post(id, company);
    }

    @PutMapping("/{id}")
    public Response<Company> put(@PathVariable final ObjectId id,
                                 @RequestBody final Company company) {

        return companyService.put(id, company);
    }

    @PatchMapping("/{id}")
    public Response<Company> patch(@PathVariable final ObjectId id,
                                   @RequestBody final Company company) {

        return companyService.patch(id, company);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable final ObjectId id) {

        companyService.delete(id);
    }
}
