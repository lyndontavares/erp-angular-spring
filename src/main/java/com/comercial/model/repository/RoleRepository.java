package com.comercial.model.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.comercial.model.commons.Pessoa;
import com.comercial.model.commons.Role;
import com.comercial.model.commons.enums.PessoaRole;

@RepositoryRestResource(collectionResourceRel = "role", path = "role", exported = false)
public interface RoleRepository extends PagingAndSortingRepository<Role, Long> {

    
  /*  @Query("delete from Role r where r.pessoa = ?1 and r.pessoaRole in ?2")
    void deleteRoleDiferenteDe(Pessoa pessoa ,List<PessoaRole> roles);*/
    
    void deleteByPessoaAndPessoaRoleNotIn(Pessoa pessoa ,List<PessoaRole> roles);
    void deleteByPessoa( Pessoa pessoa );
    
 
}
