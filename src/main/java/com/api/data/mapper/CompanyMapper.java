package com.api.data.mapper;

import com.api.data.entity.CompanyEntity;
import com.api.data.presentation.Company;
import com.api.data.presentation.Company.Meta;
import com.api.data.presentation.Company.ObjectData;

import org.springframework.stereotype.Component;

@Component
public class CompanyMapper implements Mapper<CompanyEntity, Company> {

    @Override
    public CompanyEntity toEntity(final Company company) {

        return CompanyEntity.builder()
                            .name(company.getData().getName())
                            .website(company.getData().getWebsite())
                            .build();
    }

    @Override
    public Company toPresentation(final CompanyEntity companyEntity) {

        return Company.builder()
                      .data(ObjectData.builder()
                                      .name(companyEntity.getName())
                                      .website(companyEntity.getWebsite())
                                      .build())
                      ._meta(Meta.builder()
                                 .createdBy(companyEntity.getCreatedBy())
                                 .lastModifiedBy(companyEntity.getLastModifiedBy())
                                 .createdDate(companyEntity.getCreatedDate())
                                 .lastModifiedDate(companyEntity.getLastModifiedDate())
                                 .build())
                      .build();
    }
}
