package com.comercial.model.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.comercial.model.financeiro.Titulo;

@RepositoryRestResource(collectionResourceRel = "conta", path = "conta", exported = true)
public interface ContaRepository extends PagingAndSortingRepository<Titulo, Long>{

}
