package com.api.data.mapper;

import lombok.val;

import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public interface Mapper<E, P> {

    E toEntity(final P p);

    P toPresentation(final E e);

    default List<E> toEntity(final List<P> ps) {

        return ps.stream().map(this::toEntity).collect(Collectors.toList());
    }

    default List<P> toPresentation(final List<E> es) {

        return es.stream().map(e -> toPresentation(e)).collect(Collectors.toList());
    }
}
