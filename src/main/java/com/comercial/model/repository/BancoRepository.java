package com.comercial.model.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.comercial.model.financeiro.Banco;

@RepositoryRestResource(collectionResourceRel = "banco", path = "banco", exported = true)
public interface BancoRepository extends PagingAndSortingRepository<Banco, Long> {

}
