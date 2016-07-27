package com.comercial.model.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.comercial.model.commons.Fatura;

 
@RepositoryRestResource(collectionResourceRel = "fatura", path = "fatura", exported = true)
public interface FaturaRepository extends PagingAndSortingRepository<Fatura, Long>
{

}