package com.api.data.entity;

import com.api.data.presentation.Company;
import com.api.data.presentation.Company.Meta;
import com.api.data.presentation.Company.ObjectData;

import lombok.Builder;
import lombok.Data;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Builder
@Document(collection = "company")
public class CompanyEntity extends CommonEntity {

    private String name;
    private String website;
}
