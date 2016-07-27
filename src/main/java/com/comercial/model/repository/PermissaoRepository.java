package com.comercial.model.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.comercial.model.autenticacao.Permissao;

@RepositoryRestResource(collectionResourceRel="permissao",path="permissao",exported=true)
public interface PermissaoRepository extends PagingAndSortingRepository<Permissao, Long>  {

    Iterable<Permissao> findByUsuarioId(long id);
    
}
