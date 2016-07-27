package com.comercial.model.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.comercial.model.commons.SubGrupo;

@RepositoryRestResource(collectionResourceRel="subgrupo",path="subgrupo",exported=true)
public interface SubGrupoRepository extends PagingAndSortingRepository<SubGrupo, Long>
{

}
