package com.comercial.model.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.comercial.model.commons.Grupo;

@RepositoryRestResource(collectionResourceRel="grupo",path="grupo",exported=true)
public interface GrupoRepository extends PagingAndSortingRepository<Grupo, Long>
{

}
