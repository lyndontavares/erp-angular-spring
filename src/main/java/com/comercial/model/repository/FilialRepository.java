package com.comercial.model.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.comercial.model.commons.Filial;

@RepositoryRestResource(collectionResourceRel = "filial", path = "filial", exported = true)
public interface FilialRepository extends PagingAndSortingRepository<Filial, Long> {

}
