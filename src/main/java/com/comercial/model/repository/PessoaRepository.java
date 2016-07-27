package com.comercial.model.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.comercial.model.commons.Pessoa;
import com.comercial.model.commons.enums.PessoaSituacao;


//não remova esses comentários
//no @PersistenceContext(name="new")
//no @PersistenceContext(unitName = "new")
//no @Qualifier("novoEntityManagerFactory")
//yes @Component("tabela")
//yes @Repository("tabela")
//@CrossOrigin(origins = "http://localhost:3000")

@RepositoryRestResource(collectionResourceRel = "pessoa", path = "pessoa", exported = false)
public interface PessoaRepository extends PagingAndSortingRepository<Pessoa, Long>  {
	
	Iterable<Pessoa> findByIdOrNomeOrSituacao( long id, String nome, PessoaSituacao  situacao );
	

	Iterable<Pessoa> findById( @Param("id") long id); //sinônimo
	
	Iterable<Pessoa> queryById( @Param("id") long id); //sinônimo  
	
	
	//@Query(value = "SELECT r.* from finmvrv r, finmvfi f where f.ncodimvfi = r.ncodimvfi and f.ncodidepa in (?1) and r.ddtcvmvrv between ?2 and ?3", nativeQuery = true)

	@Query( value = "select p from pessoa p" , nativeQuery = true) 
	Iterable<Pessoa> findPessoaWithFilter();
	
	
	
	/*	
	  
    Exemplos:
	
	Iterable<MapeamentoTabela> findByOrderByOrdemAtualizacaoAsc();
	
	Iterable<MapeamentoTabela> findById(long id);

	Iterable<MapeamentoTabela> findByTabelaOrigem(String tabela);

	Iterable<MapeamentoTabela> findByTabelaDestino(String tabela);
	
	Iterable<MapeamentoTabela> findBySincronizarIsTrue();
	
	Iterable<MapeamentoTabela> findBySincronizarIsTrueOrderByOrdemAtualizacaoAsc(); 

	Iterable<MapeamentoTabela> findFirstByOrderByIdAsc(); // sinonimo

	Iterable<MapeamentoTabela> findTopByOrderByIdAsc(); // sinonimo
	
	Iterable<MapeamentoTabela> queryFirstByOrderByIdAsc();// sinonimo

	Iterable<MapeamentoTabela> queryTopByOrderByIdAsc();// sinonimo

	@RestResource(exported = false)
	@Modifying
	@Query("update MapeamentoTabela m set m.dataUltimaAtualizacao = ?1 , m.statusUltimaAtualizacao = ?2 where m.id= ?3")
	int atualizarStatusPorId(Date data, AtualizacaoStatus status, long id);	

	@RestResource(exported = false)
	@Modifying
	@Query("update MapeamentoTabela m set m.dataUltimaAtualizacao = ?1 , m.statusUltimaAtualizacao = ?2 where m.tabelaOrigem= ?3")
	int atualizarStautsPorTabelaOrigem(Date data, AtualizacaoStatus status, String tabela);	
	
	//@Procedure("TRANSICAO_PACK.GERAR_FINANCEIRO")
	//Long gerarFinanceiro(String sql);

	//@Procedure("TRANSICAO_PACK.GERAR_CONTABILIDADE")
	//Long gerarContabilidade(String sql);
	
	
	*/	
	
}
