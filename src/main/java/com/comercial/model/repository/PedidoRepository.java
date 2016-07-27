package com.comercial.model.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.comercial.model.commons.Pedido;

@RepositoryRestResource(collectionResourceRel = "catalogo", path = "catalogo", exported = true)
public interface PedidoRepository extends PagingAndSortingRepository<Pedido, Long> {

}
