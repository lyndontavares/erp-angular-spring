package com.comercial.model.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.comercial.model.autenticacao.Funcionalidade;

@RepositoryRestResource(collectionResourceRel="funcionalidade",path="funcionalidade",exported=true)
public interface FuncionalidadeRepository extends PagingAndSortingRepository<Funcionalidade, Long> {

}
