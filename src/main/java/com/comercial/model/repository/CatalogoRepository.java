package com.comercial.model.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.comercial.model.commons.Catalogo;

@RepositoryRestResource(collectionResourceRel = "catalogo", path = "catalogo", exported = true)
public interface CatalogoRepository extends PagingAndSortingRepository<Catalogo, Long> {

}
