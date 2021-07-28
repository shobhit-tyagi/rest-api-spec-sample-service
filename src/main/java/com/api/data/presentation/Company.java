package com.api.data.presentation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.bouncycastle.asn1.bc.ObjectData;
import org.bson.types.ObjectId;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Company {

    private ObjectId id;
    private ObjectData data;
    private Meta _meta;

    @Data
    @Builder
    public static class ObjectData {

        private String name;
        private String website;
    }

    @Data
    @Builder
    public static class Meta {

        private String createdBy;
        private String lastModifiedBy;
        private LocalDateTime createdDate;
        private LocalDateTime lastModifiedDate;
    }

    public static class Fields {

        public static final String ID = "id";
        public static final String NAME = "name";
        public static final String WEBSITE = "website";
        public static final String CREATED_BY = "createdBy";
        public static final String LAST_MODIFIED_BY = "lastModifiedBy";
        public static final String CREATED_DATE = "createdDate";
        public static final String LAST_MODIFIED_DATE = "lastModifiedDate";
    }
}
