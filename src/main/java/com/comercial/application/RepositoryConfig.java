package com.comercial.application;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

import com.comercial.model.autenticacao.Funcionalidade;
import com.comercial.model.autenticacao.Permissao;
import com.comercial.model.autenticacao.Usuario;
import com.comercial.model.commons.Catalogo;
import com.comercial.model.commons.Cidade;
import com.comercial.model.commons.Configuracao;
import com.comercial.model.commons.Contato;
import com.comercial.model.commons.Cotacao;
import com.comercial.model.commons.Estado;
import com.comercial.model.commons.Estoque;
import com.comercial.model.commons.Fatura;
import com.comercial.model.commons.FichaProduto;
import com.comercial.model.commons.Filial;
import com.comercial.model.commons.Grupo;
import com.comercial.model.commons.ItemFatura;
import com.comercial.model.commons.ItemPedido;
import com.comercial.model.commons.Marca;
import com.comercial.model.commons.Pais;
import com.comercial.model.commons.Pedido;
import com.comercial.model.commons.Pessoa;
import com.comercial.model.commons.PlanoConta;
import com.comercial.model.commons.Role;
import com.comercial.model.commons.SubGrupo;
import com.comercial.model.commons.Unidade;
import com.comercial.model.financeiro.Agencia;
import com.comercial.model.financeiro.Banco;
import com.comercial.model.financeiro.Caixa;
import com.comercial.model.financeiro.Cheque;
import com.comercial.model.financeiro.MovimentoCaixa;
import com.comercial.model.financeiro.Talao;
import com.comercial.model.financeiro.Titulo;
import com.comercial.model.notify.Notificacao;
import com.comercial.model.sqldinamico.Artefato;

@Configuration
public class RepositoryConfig extends RepositoryRestMvcConfiguration
{
    @Override
    protected void configureRepositoryRestConfiguration(RepositoryRestConfiguration config)
    {
        config.exposeIdsFor(Banco.class);
        config.exposeIdsFor(Agencia.class);
        config.exposeIdsFor(Cidade.class);
        config.exposeIdsFor(Contato.class);
        config.exposeIdsFor(Fatura.class);
        config.exposeIdsFor(ItemFatura.class);
        config.exposeIdsFor(Pessoa.class);
        config.exposeIdsFor(Unidade.class);
        config.exposeIdsFor(Estoque.class);
        config.exposeIdsFor(Funcionalidade.class);
        config.exposeIdsFor(Permissao.class);
        config.exposeIdsFor(Catalogo.class);
        config.exposeIdsFor(Titulo.class);
        config.exposeIdsFor(Grupo.class);
        config.exposeIdsFor(SubGrupo.class);
        config.exposeIdsFor(Marca.class);
        config.exposeIdsFor(PlanoConta.class);
        config.exposeIdsFor(Pedido.class);
        config.exposeIdsFor(ItemPedido.class);
        config.exposeIdsFor(FichaProduto.class);
        config.exposeIdsFor(Filial.class);
        config.exposeIdsFor(Configuracao.class);
        config.exposeIdsFor(Cotacao.class);
        config.exposeIdsFor(Role.class);
        config.exposeIdsFor(Usuario.class);
        config.exposeIdsFor(Notificacao.class);
        config.exposeIdsFor(Artefato.class);
        config.exposeIdsFor(Pais.class);
        config.exposeIdsFor(Estado.class);
        config.exposeIdsFor(Caixa.class);
        config.exposeIdsFor(MovimentoCaixa.class);
        config.exposeIdsFor(Talao.class);
        config.exposeIdsFor(Cheque.class);
        
    }

}
