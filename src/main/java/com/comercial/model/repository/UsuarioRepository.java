package com.comercial.model.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.comercial.model.autenticacao.Usuario;
import com.comercial.model.autenticacao.enums.UsuarioSituacao;

@RepositoryRestResource(collectionResourceRel = "usuario", path = "usuario", exported = true)
public interface UsuarioRepository extends PagingAndSortingRepository<Usuario, Long>
{
    Usuario findByNomeIgnoreCase(String nome);

    Usuario findByLoginIgnoreCase(String nome);

    Usuario findBySituacaoAndLoginIgnoreCase(UsuarioSituacao situacao, String nome);

    Usuario findBySituacaoAndNomeIgnoreCase(UsuarioSituacao situacao, String nome);

}
