package com.comercial.model.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.comercial.model.commons.SubGrupo;

@RepositoryRestResource(collectionResourceRel = "produtoSubGrupo", path = "produtoSubGrupo", exported = true)
public interface ProdutoSubGrupoRepository extends PagingAndSortingRepository<SubGrupo, Long> {

}
