package com.api.utils;

import static org.springframework.data.mongodb.core.query.Criteria.where;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.UtilityClass;
import lombok.val;

import org.apache.commons.lang3.StringUtils;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

@UtilityClass
public class CriteriaBuilder {

    private static final Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(.+?),");

    public static List<CriteriaHolder> parseFilters(final String filter) {

        if (StringUtils.isEmpty(filter)) {

            return new ArrayList<CriteriaHolder>();
        }

        val criteriaList = new ArrayList<CriteriaHolder>();
        val matcher = pattern.matcher(filter + ",");
        while (matcher.find()) {

            CriteriaHolder criteriaHolder = new CriteriaHolder(matcher.group(1),
                                                               matcher.group(2),
                                                               matcher.group(3));

            criteriaList.add(criteriaHolder);
        }
        return criteriaList;
    }

    public static void addFieldToQuery(final Query query, final CriteriaHolder filter, final List<String> filterableFields) {

        if (query != null && filterableFields.contains(filter.getKey())) {

            query.addCriteria(toCriteria(filter));
        }
    }

    public static void addBooleanToQuery(final Query query, final CriteriaHolder filter) {

        if (query != null && (filter.getValue() instanceof String) && Arrays.asList("true", "false").contains(((String) filter.getValue()))) {

            filter.setValue(Boolean.parseBoolean((String) filter.getValue()));
            query.addCriteria(toCriteria(filter));
        }
    }

    public static void addObjectIdToQuery(final Query query, final CriteriaHolder filter) {

        try {

            if (query != null && (filter.getValue() instanceof String)) {

                val filterValue = new ObjectId((String) filter.getValue());
                filter.setValue(filterValue);
                query.addCriteria(toCriteria(filter));
            }
        } catch(Exception ex) {

            return;
        }
    }

    public static void addLongToQuery(final Query query, final CriteriaHolder filter) {

        if (query != null && (filter.getValue() instanceof String)) {

            try {

                filter.setValue(Long.parseLong((String) filter.getValue()));
                query.addCriteria(toCriteria(filter));

            } catch (Exception ex) {

                return;
            }
        }
    }

    public static void addDateToQuery(final Query query, final CriteriaHolder filter) {

        if (query != null && (filter.getValue() instanceof String)) {

            try {

                val localDateTime = LocalDateTime.parse((String) filter.getValue());
                final ZoneOffset offsetStandard = localDateTime.atZone(ZoneOffset.UTC)
                                                               .getOffset();
                filter.setValue(Date.from(localDateTime.atOffset(offsetStandard).toInstant()));
                query.addCriteria(toCriteria(filter));

            } catch (Exception ex) {

                return;
            }
        }
    }

    public static Criteria toCriteria(final CriteriaHolder criteriaHolder) {

        switch(criteriaHolder.getOperation()) {

            case ">": return where(criteriaHolder.getKey()).gt(criteriaHolder.getValue());
            case "<": return where(criteriaHolder.getKey()).lt(criteriaHolder.getValue());
            case ":": return where(criteriaHolder.getKey()).is(criteriaHolder.getValue());
            default: return null;
        }
    }
}

@Data
@AllArgsConstructor
class CriteriaHolder {

    private String key;
    private String operation;
    private Object value;
}
