package com.api.dao;

import com.api.data.entity.CompanyEntity;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public interface CompanyDao extends MongoRepository<CompanyEntity, ObjectId>, GenericDao<CompanyEntity> {

}
