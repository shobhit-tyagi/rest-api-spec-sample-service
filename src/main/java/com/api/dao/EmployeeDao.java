package com.api.dao;

import com.api.data.entity.CompanyEntity;
import com.api.data.entity.EmployeeEntity;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public interface EmployeeDao extends MongoRepository<EmployeeEntity, ObjectId>, GenericDao {

}
