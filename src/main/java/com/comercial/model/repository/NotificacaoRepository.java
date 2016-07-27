package com.comercial.model.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.comercial.model.notify.Notificacao;

@RepositoryRestResource(collectionResourceRel = "notificacao", path = "notificacao", exported = true)
public interface NotificacaoRepository extends PagingAndSortingRepository<Notificacao, Long> {

    
    Iterable<Notificacao> findByDestinatarioId(long id);
    
}
