package com.programadorescl.userpetservice.infrastructure.mappers;

import java.util.List;

public interface GenericMapper<E, D> {
    E toEntity(D d);

    D toDomainModel(E e);

    List<D> toDomainModels(List<E> listEntities);

    List<E> toEntities(List<D> listDomainModels);
}
