package com.api.service;

import com.api.data.presentation.Company;
import com.api.data.presentation.Response;

import org.bson.types.ObjectId;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CompanyService {

    Response<Company> get(final ObjectId id, final List<String> fields);

    Response<List<Company>> getAll(final List<String> fields, final String filter, final Pageable pageable);

    Response<Company> post(final ObjectId id, final Company company);

    Response<Company> put(final ObjectId id, final Company company);

    Response<Company> patch(final ObjectId id, final Company company);

    void delete(final ObjectId id);
}
