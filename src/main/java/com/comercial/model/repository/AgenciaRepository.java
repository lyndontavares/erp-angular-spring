package com.comercial.model.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.comercial.model.financeiro.Agencia;

@RepositoryRestResource(collectionResourceRel = "agencia", path = "agencia", exported = true)
public interface AgenciaRepository extends PagingAndSortingRepository<Agencia, Long> {

}
