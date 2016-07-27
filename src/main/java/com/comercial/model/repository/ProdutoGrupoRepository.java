package com.comercial.model.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.comercial.model.commons.Grupo;

@RepositoryRestResource(collectionResourceRel = "produtoGrupo", path = "produtoGrupo", exported = true)
public interface ProdutoGrupoRepository extends PagingAndSortingRepository<Grupo, Long>{

}
