package com.comercial.model.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.comercial.model.commons.Cidade;

@RepositoryRestResource(collectionResourceRel = "cidade", path = "cidade", exported = true)
public interface CidadeRepository extends PagingAndSortingRepository<Cidade, Long> {

}
