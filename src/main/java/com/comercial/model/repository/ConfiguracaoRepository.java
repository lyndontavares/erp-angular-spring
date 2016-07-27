package com.comercial.model.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.comercial.model.commons.Configuracao;
import com.comercial.model.commons.enums.TipoProfile;

@RepositoryRestResource(collectionResourceRel = "configuracao", path = "configuracao", exported = true)
public interface ConfiguracaoRepository extends PagingAndSortingRepository<Configuracao, Long> {

    
    Iterable<Configuracao> findFisrt1ByProfile( TipoProfile profile);
}
