package com.api.service;

import com.api.dao.CompanyDao;
import com.api.data.mapper.CompanyMapper;
import com.api.data.presentation.Company;
import com.api.data.presentation.Company.Fields;
import com.api.data.presentation.Response;
import com.api.utils.QueryBuilder;
import com.api.utils.exception.NotFound;
import com.api.validator.CompanyValidator;

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
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private CompanyMapper companyMapper;
    @Autowired
    private CompanyValidator companyValidator;

    @Override
    public Response<Company> get(final ObjectId id, final List<String> fields) {

        val query = new Query();
        QueryBuilder.resolveFields(fields, query);

        val companyEntity = companyDao.findById(id, query.getFieldsObject());
        if (companyEntity == null) {

            throw new NotFound("Requested company is not found");
        }
        return new Response<Company>(companyMapper.toPresentation(companyEntity));
    }

    @Override
    public Response<List<Company>> getAll(final List<String> fields, final String filter, final Pageable pageable) {

        return null;
    }

    @Override
    public Response<Company> post(final ObjectId id, final Company company) {

        return null;
    }

    @Override
    public Response<Company> put(final ObjectId id, final Company company) {

        return null;
    }

    @Override
    public Response<Company> patch(final ObjectId id, final Company company) {

        return null;
    }

    @Override
    public void delete(final ObjectId id) {

    }
}
