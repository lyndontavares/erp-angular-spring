package com.comercial.model.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.comercial.model.commons.Estoque;

@RepositoryRestResource(collectionResourceRel = "produto", path = "produto", exported = true)
public interface EstoqueRepository extends PagingAndSortingRepository<Estoque, Long>
{

}
