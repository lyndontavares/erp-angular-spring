package com.comercial.model.commons;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.Email;

import com.comercial.model.autenticacao.views.View;
import com.comercial.model.commons.enums.PessoaSituacao;
import com.comercial.model.commons.enums.Sexo;
import com.comercial.model.commons.enums.SimNao;
import com.comercial.model.commons.enums.TipoPessoa;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(indexes = { @Index(columnList = "nome,documento", unique = true) })
public class Pessoa
{

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false, length = 100)
    private String nome;

    private String nomeFantasia;

    @Enumerated(EnumType.STRING)
    private TipoPessoa tipoPessoa;

    @Enumerated(EnumType.STRING)
    private PessoaSituacao situacao;

    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    @Enumerated(EnumType.STRING)
    private SimNao credito;

    private BigDecimal limite;

    private String telefone;

    private String celular;

    @Email(message = "{validation.email.message}")
    private String email;

    private String endereco;
    
    private String documento;
 

    @ManyToOne
    @JsonIgnore
    private Cidade cidade;

    private String observacao;

    @Temporal(TemporalType.DATE)
    private Date nascimento;

    @Temporal(TemporalType.DATE)
    private Date cadastro;

    @OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.MERGE,  mappedBy = "pessoa")//cascade=CascadeType.MERGE ,
    @JsonView(View.class)
    private List<Role> roles;
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "pessoa")
    @JsonView(View.class)
    private List<Contato> contatos; 

    public Date getCadastro()
    {
        return cadastro;
    }

    public void setCadastro(Date cadastro)
    {  
    
        this.cadastro = cadastro;
    }

    public Pessoa()
    {
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public String getNomeFantasia()
    {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia)
    {
        this.nomeFantasia = nomeFantasia;
    }

    public PessoaSituacao getSituacao()
    {
        return situacao;
    }

    public void setSituacao(PessoaSituacao situacao)
    {
        this.situacao = situacao;
    }

    public Sexo getSexo()
    {
        return sexo;
    }

    public void setSexo(Sexo sexo)
    {
        this.sexo = sexo;
    }

    public SimNao getCredito()
    {
        return credito;
    }

    public void setCredito(SimNao credito)
    {
        this.credito = credito;
    }

    public BigDecimal getLimite()
    {
        return limite;
    }

    public void setLimite(BigDecimal limite)
    {
        this.limite = limite;
    }

    public String getTelefone()
    {
        return telefone;
    }

    public void setTelefone(String telefone)
    {
        this.telefone = telefone;
    }

    public String getCelular()
    {
        return celular;
    }

    public void setCelular(String celular)
    {
        this.celular = celular;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getEndereco()
    {
        return endereco;
    }

    public void setEndereco(String endereco)
    {
        this.endereco = endereco;
    }

    public Cidade getCidade()
    {
        return cidade;
    }

    public void setCidade(Cidade cidade)
    {
        this.cidade = cidade;
    }

    public String getObservacao()
    {
        return observacao;
    }

    public void setObservacao(String observacao)
    {
        this.observacao = observacao;
    }

    public Date getNascimento()
    {
        return nascimento;
    }

    public void setNascimento(Date nascimento)
    {
        this.nascimento = nascimento;
    }

    public TipoPessoa getTipoPessoa()
    {
        return tipoPessoa;
    }

    public void setTipoPessoa(TipoPessoa tipoPessoa)
    {
        this.tipoPessoa = tipoPessoa;
    }

    public String getDocumento()
    {
        return documento;
    }

    public void setDocumento(String documento)
    {
        this.documento = documento;
    }

    public List<Role> getRoles()
    {
        return roles;
    }

    public void setRoles(List<Role> roles)
    {
        this.roles = roles;
 
    }
 
     public List<Contato> getContatos()
    {
        return contatos;
    }

    public void setContatos(List<Contato> contatos)
    {
        this.contatos = contatos;
    }

   

}
