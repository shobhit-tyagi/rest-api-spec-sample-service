package com.api.dao;

import com.mongodb.DBObject;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Query;

public interface GenericDao<T> {

    @Query(value = "{id : ?0}", fields = "?1")
    T findById(final ObjectId id, final Document fields);

    @Query(value = "?0", fields = "?1")
    Page<T> findByQuery(final DBObject query, final DBObject fields, final Pageable pageable);
}
