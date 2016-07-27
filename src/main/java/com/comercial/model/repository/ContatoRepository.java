package com.comercial.model.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.comercial.model.commons.Contato;

@RepositoryRestResource(collectionResourceRel = "contato", path = "contato", exported = true)
public interface ContatoRepository extends PagingAndSortingRepository<Contato, Long>{

}
