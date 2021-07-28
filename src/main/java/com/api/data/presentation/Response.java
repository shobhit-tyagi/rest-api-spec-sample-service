package com.api.data.presentation;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.domain.Page;

import java.util.HashMap;
import java.util.Map;

@Data
@JsonInclude(Include.NON_NULL)
public class Response<T> {

    private T data;
    private Pagination pagination;

    public Response(final T content) {

        this.data  = content;
    }

    public Response(final T content, final Page page) {

        this.data  = content;
        pagination = new Pagination(page);
    }

    @Data
    @AllArgsConstructor
    @JsonInclude(Include.NON_NULL)
    public static class Pagination {

        public Pagination(final Page page) {

            this.page = page.getNumber();
            this.size = page.getSize();
            this.first = page.isFirst();
            this.last = page.isLast();
            this.numberOfElements = page.getNumberOfElements();
            this.totalElements = page.getTotalElements();
            this.totalPages = page.getTotalPages();

            if (page.getSort() != null) {

                this.sort = new HashMap<>();
                page.getSort().forEach(order -> {

                    sort.put(order.getProperty().toString(), order.getDirection().toString());
                });
            }
        }

        public int page;
        public int size;
        public boolean first;
        public boolean last;
        public int numberOfElements;
        public long totalElements;
        public long totalPages;
        public Map<String, String> sort;
    }
}
