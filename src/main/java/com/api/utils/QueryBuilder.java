package com.api.utils;

import lombok.experimental.UtilityClass;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

@UtilityClass
public class QueryBuilder {

    public static void resolveFields(final List<String> fields, final Query query) {

        if (CollectionUtils.isEmpty(fields) || query == null) {

            return;
        }

        fields.stream().forEach(field -> {

            query.fields().include(field);
        });
    }
}
