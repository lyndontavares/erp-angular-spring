package com.comercial.model.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.comercial.model.commons.Marca;

@RepositoryRestResource(collectionResourceRel = "produtoMarca", path = "produtoMarca", exported = true)
public interface ProdutoMarcaRepository extends PagingAndSortingRepository<Marca, Long> {

}
