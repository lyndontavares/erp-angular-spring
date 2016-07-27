package com.comercial.model.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.comercial.model.financeiro.Titulo;

@RepositoryRestResource(collectionResourceRel = "titulo", path = "titulo", exported = true)
public interface TituloRepository extends PagingAndSortingRepository<Titulo, Long> {

}
